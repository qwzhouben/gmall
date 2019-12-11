package com.zben.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.zben.gmall.bean.*;
import com.zben.gmall.manage.mapper.ChapterMapper;
import com.zben.gmall.manage.mapper.PmsProductImageMapper;
import com.zben.gmall.manage.mapper.PmsProductInfoMapper;
import com.zben.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.zben.gmall.service.SpuService;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @DESC: 商品SPU服务实现
 * @author: zhouben
 * @date: 2019/12/3 0003 16:17
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return pmsProductInfoMapper.selectSpuByCatalog3Id(catalog3Id);
    }

    @Override
    @Transactional
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //保存spu
        pmsProductInfoMapper.saveSpuInfo(pmsProductInfo);
        if (StringUtils.isNotEmpty(pmsProductInfo.getId())) {
            //保存销售属性
            saveSaleAttr(pmsProductInfo);
            //保存图片
            saveSpuImage(pmsProductInfo);
        }
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        List<PmsProductSaleAttr> saleAttrList = pmsProductSaleAttrMapper.selectSaleAttrBySpuId(spuId);
        List<PmsProductSaleAttr> res = Lists.newArrayList();
        saleAttrList.forEach(pmsProductSaleAttr -> {
            List<PmsProductSaleAttrValue> valueList = pmsProductSaleAttrMapper.selectValueBySpuIdAndAttrId(pmsProductSaleAttr);
            pmsProductSaleAttr.setSpuSaleAttrValueList(valueList);
            res.add(pmsProductSaleAttr);
        });
        return res;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        return pmsProductImageMapper.selectImageBySpuId(spuId);
    }

    public void saveSpuImage(PmsProductInfo pmsProductInfo) {
        if (!CollectionUtils.isEmpty(pmsProductInfo.getPmsProductImageList())) {
            pmsProductInfo.getPmsProductImageList().forEach(image -> {
                image.setProductId(pmsProductInfo.getId());
                pmsProductImageMapper.saveImage(image);
            });
        }
    }

    public void saveSaleAttr(PmsProductInfo pmsProductInfo) {
        List<PmsProductSaleAttr> productSaleAttrList = pmsProductInfo.getPmsProductSaleAttrList();
        if (!CollectionUtils.isEmpty(productSaleAttrList)) {
            productSaleAttrList.forEach(pmsProductSaleAttr -> {
                pmsProductSaleAttr.setProductId(pmsProductInfo.getId());
                pmsProductSaleAttrMapper.saveSaleAttr(pmsProductSaleAttr);
                if (!CollectionUtils.isEmpty(pmsProductSaleAttr.getSpuSaleAttrValueList())) {
                    pmsProductSaleAttr.getSpuSaleAttrValueList().forEach(pmsProductSaleAttrValue -> {
                        pmsProductSaleAttrValue.setProductId(pmsProductInfo.getId());
                        pmsProductSaleAttrMapper.saveSaleAttrValue(pmsProductSaleAttrValue);
                    });
                }
            });
        }
    }

    @Override
    public List<CalculatorChapter> chapterList(Long hisId, Integer articleId) {
        List<CalculatorChapter> all = chapterMapper.chapterList(2356l, 1);
        List<CalculatorChapter> parent = all.stream().filter(calculatorChapter -> "0".equals(calculatorChapter.getParentId())).collect(Collectors.toList());
        List<CalculatorChapter> child = all.stream().filter(calculatorChapter -> !"0".equals(calculatorChapter.getParentId())).collect(Collectors.toList());

        Map<String, List<CalculatorChapter>> map = child.stream().collect(Collectors.groupingBy(CalculatorChapter::getParentId));
        List<CalculatorChapter> resChapter = Lists.newArrayList();
        for (Map.Entry<String, List<CalculatorChapter>> entity : map.entrySet()) {

            all.stream().forEach(calculatorChapter -> {
                if (entity.getKey().equals(calculatorChapter.getChapterId()+"")) {
                    CalculatorChapter chapter = calculatorChapter;
                    chapter.setChapterList(entity.getValue());
                    resChapter.add(chapter);
                    return;
                }
            });

        }

        return parent;
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String skuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrs =pmsProductSaleAttrMapper.spuSaleAttrListCheckBySku(productId, skuId);
        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        return pmsProductInfoMapper.selectSkuSaleAttrValueListBySpu(productId);
    }
}
