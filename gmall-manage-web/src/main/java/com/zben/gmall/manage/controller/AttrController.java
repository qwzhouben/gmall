package com.zben.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zben.gmall.bean.PmsBaseAttrInfo;
import com.zben.gmall.bean.PmsBaseAttrValue;
import com.zben.gmall.bean.PmsBaseSaleAttr;
import com.zben.gmall.service.AttrInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @DESC: 属性控制器
 * @author: zhouben
 * @date: 2019/12/3 0003 11:44
 */
@RestController
@CrossOrigin
public class AttrController {

    @Reference
    AttrInfoService attrInfoService;

    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        attrInfoService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    @PostMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(@RequestParam String attrId) {
        return attrInfoService.getAttrValueList(attrId);
    }

    @GetMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(@RequestParam String catalog3Id) {
        return attrInfoService.attrInfoList(catalog3Id);
    }

    /**
     * 基础销售属性列表
     */
    @PostMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return attrInfoService.baseSaleAttrList();
    }
}
