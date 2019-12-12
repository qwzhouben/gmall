package com.zben.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zben.gmall.bean.PmsSkuAttrValue;
import com.zben.gmall.bean.PmsSkuImage;
import com.zben.gmall.bean.PmsSkuInfo;
import com.zben.gmall.bean.PmsSkuSaleAttrValue;
import com.zben.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.zben.gmall.manage.mapper.PmsSkuImageMapper;
import com.zben.gmall.manage.mapper.PmsSkuInfoMapper;
import com.zben.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.zben.gmall.service.SkuService;
import com.zben.gmall.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @DESC: SKU服务实现
 * @author: zhouben
 * @date: 2019/12/6 0006 18:01
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;
    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;
    @Autowired
    RedisUtil redisUtil;

    @Override
    @Transactional
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        if (pmsSkuInfo == null) {
            return;
        }
        //保存sku信息
        pmsSkuInfoMapper.insertInfo(pmsSkuInfo);
        //保存属性值
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        skuAttrValueList.stream().forEach(pmsSkuAttrValue -> {
            pmsSkuAttrValue.setSkuId(pmsSkuInfo.getId());
            pmsSkuAttrValueMapper.insert(pmsSkuAttrValue);
        });
        //保存销售属性值
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        skuSaleAttrValueList.stream().forEach(pmsSkuSaleAttrValue -> {
            pmsSkuSaleAttrValue.setSkuId(pmsSkuInfo.getId());
            pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
        });
        //保存图片
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        skuImageList.stream().forEach(pmsSkuImage -> {
            pmsSkuImage.setSkuId(pmsSkuInfo.getId());
            pmsSkuImageMapper.insert(pmsSkuImage);
        });
    }

    @Override
    public PmsSkuInfo getBySkuId(String skuId) {
        PmsSkuInfo pmsSkuInfo;
        String key = "sku:" + skuId + ":info";
        //连接redis
        Jedis jedis = redisUtil.getJedis();
        //查询redis
        String skuInfoStr = jedis.get(key);
        if (StringUtils.isNotBlank(skuInfoStr)) {
            pmsSkuInfo = JSONObject.parseObject(skuInfoStr, PmsSkuInfo.class);
        } else {
            //设置分布式锁
            String redisLock = redisUtil.getRedisLock(jedis, 5000L, 5000L, skuId);
            if (StringUtils.isEmpty(redisLock)) {
                System.out.println("获取锁失败");
                return null;
            }
            pmsSkuInfo = getBySkuIdBd(skuId);
            if (pmsSkuInfo == null) {
                jedis.setex(key, 180, JSON.toJSONString(""));
            } else {
                jedis.set(key, JSON.toJSONString(pmsSkuInfo));
            }
            redisUtil.redisUnlock(jedis, skuId, redisLock);
        }
        //没有查到  查数据库
        return pmsSkuInfo;
    }

    public PmsSkuInfo getBySkuIdBd(String skuId) {
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectById(skuId);
        List<PmsSkuImage> imageList = pmsSkuImageMapper.selectBySkuId(skuId);
        if (pmsSkuInfo != null) {
            pmsSkuInfo.setSkuImageList(imageList);
        }
        return pmsSkuInfo;
    }
}
