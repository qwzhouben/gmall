package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @DESC: 属性
 * @AUTHOR: zhouben
 * @DATE: 2019/12/3 0003 11:13
 */
@Mapper
public interface AttrInfoMapper {

    @Select("select * from pms_base_attr_info where catalog3_id=#{catalog3Id}")
   List<PmsBaseAttrInfo> selectAttrInfoByCatalog3Id(@Param("catalog3Id") String catalog3Id);

    @Insert("insert into pms_base_attr_info (attr_name, catalog3_id) values(#{attrName}, #{catalog3Id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    @Insert("insert into pms_base_attr_value (value_name, attr_id) values(#{valueName}, #{attrId})")
    void saveAttrValue(PmsBaseAttrValue attrValue);

    @Select("select * from pms_base_attr_value where attr_id=#{attrId}")
    List<PmsBaseAttrValue> getAttrValueList(@Param("attrId") String attrId);

    @Delete("delete from pms_base_attr_value where attr_id=#{attrId}")
    void deleteByAttrId(@Param("attrId") String attrId);
}
