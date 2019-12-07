package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsSkuAttrValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @DESC:sku属性值
 * @AUTHOR: zhouben
 * @DATE: 2019/12/7 0007 10:27
 */
@Mapper
public interface PmsSkuAttrValueMapper {

    @Insert("INSERT INTO pms_sku_attr_value(attr_id, value_id, sku_id) VALUES(#{attrId}, #{valueId}, #{skuId})")
    void insert(PmsSkuAttrValue pmsSkuAttrValue);
}
