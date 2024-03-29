package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsSkuInfo;
import org.apache.ibatis.annotations.*;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/12/6 0006 18:04
 */
@Mapper
public interface PmsSkuInfoMapper {

    @Insert("insert into pms_sku_info(product_id, price, sku_name, sku_desc, weight, catalog3_id, sku_default_img) " +
            " values(#{productId}, #{price}, #{skuName}, #{skuDesc}, #{weight}, #{catalog3Id}, #{skuDefaultImg})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertInfo(PmsSkuInfo pmsSkuInfo);

    @Select("select * from pms_sku_info where id=#{skuId}")
    PmsSkuInfo selectById(@Param("skuId") String skuId);
}
