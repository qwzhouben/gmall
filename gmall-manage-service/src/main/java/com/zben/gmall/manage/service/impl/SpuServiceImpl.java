package com.zben.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zben.gmall.bean.PmsProductInfo;
import com.zben.gmall.manage.mapper.SpuMapper;
import com.zben.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @DESC: 商品SPU服务实现
 * @author: zhouben
 * @date: 2019/12/3 0003 16:17
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    SpuMapper spuMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return spuMapper.selectSpuByCatalog3Id(catalog3Id);
    }
}
