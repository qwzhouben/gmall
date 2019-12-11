package com.zben.gmall.service;

import com.zben.gmall.bean.PmsSkuInfo;

/**
 * @DESC: SKU服务
 * @AUTHOR: zhouben
 * @DATE: 2019/12/6 0006 18:00
 */
public interface SkuService {

    /**
     * 保存sku
     */
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getBySkuId(String skuId);
}
