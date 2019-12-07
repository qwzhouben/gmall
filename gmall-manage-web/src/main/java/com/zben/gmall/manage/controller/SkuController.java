package com.zben.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zben.gmall.bean.PmsSkuInfo;
import com.zben.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @DESC: Sku
 * @author: zhouben
 * @date: 2019/12/6 0006 17:54
 */
@RestController
@CrossOrigin
public class SkuController {

    @Reference
    SkuService skuService;

    /**
     * 保存SKU
     */
    @PostMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}
