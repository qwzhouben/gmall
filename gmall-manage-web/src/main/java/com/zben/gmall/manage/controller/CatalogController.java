package com.zben.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zben.gmall.bean.PmsBaseCatalog1;
import com.zben.gmall.bean.PmsBaseCatalog2;
import com.zben.gmall.bean.PmsBaseCatalog3;
import com.zben.gmall.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @DESC: 分类控制器
 * @author: zhouben
 * @date: 2019/12/3 0003 11:01
 */
@RestController
public class CatalogController {

    @Reference
    CatalogService catalogService;

    /**
     * 获取一级分类
     * @return
     */
    @PostMapping("/getCatalog1")
    @CrossOrigin
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }

    /**
     * 获取一级分类
     * @return
     */
    @PostMapping("/getCatalog2")
    @CrossOrigin
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    /**
     * 获取一级分类
     * @return
     */
    @PostMapping("/getCatalog3")
    @CrossOrigin
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }
}
