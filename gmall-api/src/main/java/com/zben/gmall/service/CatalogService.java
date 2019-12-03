package com.zben.gmall.service;

import com.zben.gmall.bean.PmsBaseCatalog1;
import com.zben.gmall.bean.PmsBaseCatalog2;
import com.zben.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @DESC: 分类服务
 * @author: zhouben
 * @date: 2019/12/3 0003 11:09
 */
public interface CatalogService {

    /**
     * 获取一级分类
     * @return
     */
    List<PmsBaseCatalog1> getCatalog1();

    /**
     * 根据一级分类id查询二级分类
     * @param catalog1Id
     * @return
     */
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 根据二级分类id查询二级分类
     * @param catalog2Id
     * @return
     */
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
