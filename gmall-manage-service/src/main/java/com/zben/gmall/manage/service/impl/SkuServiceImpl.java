package com.zben.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zben.gmall.bean.PmsSkuAttrValue;
import com.zben.gmall.bean.PmsSkuImage;
import com.zben.gmall.bean.PmsSkuInfo;
import com.zben.gmall.bean.PmsSkuSaleAttrValue;
import com.zben.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.zben.gmall.manage.mapper.PmsSkuImageMapper;
import com.zben.gmall.manage.mapper.PmsSkuInfoMapper;
import com.zben.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.zben.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
}
