package com.zben.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.zben.gmall.bean.PmsProductSaleAttr;
import com.zben.gmall.bean.PmsSkuInfo;
import com.zben.gmall.bean.PmsSkuSaleAttrValue;
import com.zben.gmall.service.SkuService;
import com.zben.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @DESC: 详情 Controller
 * @author: zhouben
 * @date: 2019/12/7 0007 12:29
 */
@Controller
public class ItemController {

    @Reference
    SkuService skuService;
    @Reference
    SpuService spuService;

    @GetMapping("index")
    public String index(ModelMap modelMap) {
        modelMap.put("hello", "你好");
        return "index";
    }

    /**
     * 详情页
     */
    @GetMapping("{skuId}.html")
    public String item(@PathVariable("skuId") String skuId, ModelMap modelMap) {
        PmsSkuInfo pmsSkuInfo = skuService.getBySkuId(skuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrList = spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(), skuId);
        //sku信息
        modelMap.put("skuInfo", pmsSkuInfo);
        //销售属性
        modelMap.put("spuSaleAttrListCheckBySku", pmsProductSaleAttrList);
        // 查询当前sku的spu的其他sku的集合的hash表
        List<PmsSkuInfo> skuInfoList = spuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
        Map<String, String> skuSaleAttrHash = new HashMap<>();
        skuInfoList.stream().forEach(skuInfo -> {
            String k ="";
            String v = skuInfo.getId();
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";
            }
            skuSaleAttrHash.put(k, v);
        });
        modelMap.put("skuSaleAttrHashJsonStr", JSON.toJSONString(skuSaleAttrHash));
        return "item";
    }

}
