package com.zben.gmall.service;

import com.zben.gmall.bean.PmsProductInfo;

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
}
