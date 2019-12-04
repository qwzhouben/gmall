package com.zben.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zben.gmall.bean.PmsBaseSaleAttr;
import com.zben.gmall.bean.PmsProductInfo;
import com.zben.gmall.service.SpuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

        return "success";
    }

    /**
     * 上传图片
     */
    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        //上传到服务器

        //将图片存储路径返回给前端
        String url = "https://img.alicdn.com/imgextra/i2/197232874/O1CN01cWbmXU1X6KnJF0BJ5_!!197232874.jpg";
        return url;
    }
}
