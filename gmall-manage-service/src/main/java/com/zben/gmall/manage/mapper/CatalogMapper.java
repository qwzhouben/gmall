package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.PmsBaseCatalog1;
import com.zben.gmall.bean.PmsBaseCatalog2;
import com.zben.gmall.bean.PmsBaseCatalog3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @DESC: 分类
 * @AUTHOR: zhouben
 * @DATE: 2019/12/3 0003 11:13
 */
@Mapper
public interface CatalogMapper {

    /**
     * 查询所有一级分类
     * @return
     */
    @Select("select t.* from pms_base_catalog1 t")
    List<PmsBaseCatalog1> selectAll();

    /**
     * 根据一级分类id查询二级分类
     * @param catalog1Id
     * @return
     */
    @Select("select * from pms_base_catalog2 where catalog1_id=#{catalog1Id}")
    List<PmsBaseCatalog2> selectCatalog2ByCatalog1Id(@Param("catalog1Id") String catalog1Id);

    /**
     * 根据二级分类id查询三级分类
     * @param catalog2Id
     * @return
     */
    @Select("select * from pms_base_catalog3 where catalog2_id=#{catalog2Id}")
    List<PmsBaseCatalog3> selectCatalog3ByCatalog2Id(@Param("catalog2Id") String catalog2Id);
}
