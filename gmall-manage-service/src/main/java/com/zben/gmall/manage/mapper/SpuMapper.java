package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @DESC: spu
 * @AUTHOR: zhouben
 * @DATE: 2019/12/3 0003 16:17
 */
@Mapper
public interface SpuMapper {

    /**
     * 根据三级分类查询商品spu
     * @param catalog3Id
     * @return
     */
    @Select("select * from pms_product_info where catalog3_id=#{catalog3Id}")
    List<PmsProductInfo> selectSpuByCatalog3Id(@Param("catalog3Id") String catalog3Id);
}
