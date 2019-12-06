package com.zben.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zben.gmall.bean.*;
import com.zben.gmall.service.SpuService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @DESC: 商品spu控制器
 * @author: zhouben
 * @date: 2019/12/3 0003 16:13
 */
@RestController
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    /**
     * spu列表
     */
    @GetMapping("spuList")
    public List<PmsProductInfo> spuList(@RequestParam String catalog3Id) {
        return spuService.spuList(catalog3Id);
    }

    /**
     * 保存spu
     */
    @PostMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    /**
     * 销售属性
     */
    @GetMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(@RequestParam String spuId) {
        return spuService.spuSaleAttrList(spuId);
    }

    /**
     * 图片列表
     */
    @GetMapping("spuImageList")
    public List<PmsProductImage> spuImageList(@RequestParam String spuId) {
        return spuService.spuImageList(spuId);
    }

    @GetMapping("chapterList")
    public List<CalculatorChapter> chapterList(Long hisId, Integer articleId) {
        return spuService.chapterList(hisId, articleId);
    }
}
