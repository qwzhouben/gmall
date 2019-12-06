package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsProductSaleAttr;
import com.zben.gmall.bean.PmsProductSaleAttrValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/12/4 0004 21:00
 */
@Mapper
public interface PmsProductSaleAttrMapper {

    @Insert("insert into pms_product_sale_attr(product_id, sale_attr_id, sale_attr_name) values(#{productId}, #{saleAttrId}, #{saleAttrName})")
    void saveSaleAttr(PmsProductSaleAttr pmsProductSaleAttr);

    @Insert("insert into pms_product_sale_attr_value(product_id, sale_attr_id, sale_attr_value_name) values(#{productId}, #{saleAttrId}, #{saleAttrValueName})")
    void saveSaleAttrValue(PmsProductSaleAttrValue pmsProductSaleAttrValue);

    @Select("select * from pms_product_sale_attr where product_id=#{spuId}")
    List<PmsProductSaleAttr> selectSaleAttrBySpuId(@Param("spuId") String spuId);

    @Select("select * from pms_product_sale_attr_value where product_id=#{productId} and sale_attr_id=#{saleAttrId}")
    List<PmsProductSaleAttrValue> selectValueBySpuIdAndAttrId(PmsProductSaleAttr pmsProductSaleAttr);
}
