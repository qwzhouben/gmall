package com.zben.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zben.gmall.bean.PmsBaseAttrInfo;
import com.zben.gmall.bean.PmsBaseAttrValue;
import com.zben.gmall.bean.PmsBaseSaleAttr;
import com.zben.gmall.manage.mapper.AttrInfoMapper;
import com.zben.gmall.service.AttrInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @DESC: 属性服务实现
 * @author: zhouben
 * @date: 2019/12/3 0003 11:54
 */
@Service
public class AttrInfoServiceImpl implements AttrInfoService {

    @Autowired
    AttrInfoMapper attrInfoMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        return attrInfoMapper.selectAttrInfoByCatalog3Id(catalog3Id);
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        return attrInfoMapper.getAttrValueList(attrId);
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return attrInfoMapper.selectAllBaseSaleAttr();
    }

    @Override
    @Transactional
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //save
        if (StringUtils.isEmpty(pmsBaseAttrInfo.getId())) {
            attrInfoMapper.saveAttrInfo(pmsBaseAttrInfo);
            if (StringUtils.isNotEmpty(pmsBaseAttrInfo.getId())) {
                saveAttrValue(pmsBaseAttrInfo);
            }
        } else {    //update
            attrInfoMapper.deleteByAttrId(pmsBaseAttrInfo.getId());
            saveAttrValue(pmsBaseAttrInfo);
        }
    }

    public void saveAttrValue(PmsBaseAttrInfo pmsBaseAttrInfo) {
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        attrValueList.forEach(attrValue -> {
            attrValue.setAttrId(pmsBaseAttrInfo.getId());
            attrInfoMapper.saveAttrValue(attrValue);
        });
    }

}
