package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsSkuImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @DESC: sku图片
 * @AUTHOR: zhouben
 * @DATE: 2019/12/7 0007 10:36
 */
@Mapper
public interface PmsSkuImageMapper {

    @Insert("INSERT INTO pms_sku_image(sku_id, img_name, img_url, product_img_id, is_default) " +
            " VALUES(#{skuId}, #{imgName}, #{imgUrl}, #{productImgId}, #{isDefault})")
    void insert(PmsSkuImage pmsSkuImage);

    @Select("SELECT * FROM pms_sku_image WHERE sku_id=#{skuId}")
    List<PmsSkuImage> selectBySkuId(@Param("skuId") String skuId);
}
