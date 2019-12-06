package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsProductImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @DESC: 图片
 * @AUTHOR: zhouben
 * @DATE: 2019/12/4 0004 20:52
 */
@Mapper
public interface PmsProductImageMapper {

    /**
     * 保存图片
     */
    @Insert("insert into pms_product_image(product_id, img_name, img_url) values(#{productId}, #{imgName}, #{imgUrl})")
    void saveImage(PmsProductImage image);

    @Select("select * from pms_product_image where product_id=#{productId}")
    List<PmsProductImage> selectImageBySpuId(@Param("productId") String productId);
}
