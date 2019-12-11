package com.zben.gmall.service;

import com.zben.gmall.bean.*;

import java.util.List;

/**
 * @DESC: 商品spu服务
 * @AUTHOR: zhouben
 * @DATE: 2019/12/3 0003 16:15
 */
public interface SpuService {

    /**
     * 根据三级分类查询商品spu
     * @param catalog3Id
     * @return
     */
    List<PmsProductInfo> spuList(String catalog3Id);

    /**
     * 保存spu
     * @param pmsProductInfo
     */
    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    /**
     * 根据商品id查询销售属性
     * @param spuId
     * @return
     */
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    /**
     * 根据商品id查询图片
     * @param spuId
     * @return
     */
    List<PmsProductImage> spuImageList(String spuId);

    List<CalculatorChapter> chapterList(Long hisId, Integer articleId);

    /**
     * 根据商品id列出销售属性值
     * @param productId
     * @return
     */
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String skuId);

    /**
     *
     * @param productId
     * @return
     */
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
}
