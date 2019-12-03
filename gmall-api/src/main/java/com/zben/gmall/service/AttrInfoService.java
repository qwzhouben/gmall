package com.zben.gmall.service;

import com.zben.gmall.bean.PmsBaseAttrInfo;
import com.zben.gmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @DESC: 属性服务
 * @AUTHOR: zhouben
 * @DATE: 2019/12/3 0003 11:53
 */
public interface AttrInfoService {

    /**
     * 获取所有属性
     * @return
     */
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    /**
     * 保存属性
     * @param pmsBaseAttrInfo
     */
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    /**
     * 根据属性id获取属性值
     * @param attrId
     * @return
     */
    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
