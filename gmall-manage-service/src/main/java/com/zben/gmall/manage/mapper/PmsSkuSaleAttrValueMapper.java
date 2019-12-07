package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsSkuSaleAttrValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @DESC: sku销售属性值
 * @AUTHOR: zhouben
 * @DATE: 2019/12/7 0007 10:29
 */
@Mapper
public interface PmsSkuSaleAttrValueMapper {

    @Insert("INSERT INTO pms_sku_sale_attr_value(sku_id, sale_attr_id, sale_attr_value_id, sale_attr_name, sale_attr_value_name)" +
            " VALUES(#{skuId}, #{saleAttrId}, #{saleAttrValueId}, #{saleAttrName}, #{saleAttrValueName})")
    void insert(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);
}
