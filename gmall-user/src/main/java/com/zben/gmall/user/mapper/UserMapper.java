package com.zben.gmall.user.mapper;

import com.zben.gmall.bean.UmsMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/11/30 0030 17:28
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     */
    @Select("select t.* from ums_member t")
    List<UmsMember> selectAllUser();

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    @Select("select t.* from ums_member t where id=#{id}")
    UmsMember selectUserById(@Param("id") String id);
}
