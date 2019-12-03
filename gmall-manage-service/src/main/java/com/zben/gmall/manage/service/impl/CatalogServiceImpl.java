package com.zben.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zben.gmall.bean.PmsBaseCatalog1;
import com.zben.gmall.bean.PmsBaseCatalog2;
import com.zben.gmall.bean.PmsBaseCatalog3;
import com.zben.gmall.manage.mapper.CatalogMapper;
import com.zben.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @DESC: 分类服务实现
 * @author: zhouben
 * @date: 2019/12/3 0003 11:11
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogMapper catalogMapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogMapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogMapper.selectCatalog2ByCatalog1Id(catalog1Id);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogMapper.selectCatalog3ByCatalog2Id(catalog2Id);
    }
}
