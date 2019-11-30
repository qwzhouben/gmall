package com.zben.gmall.user.mapper;

import com.zben.gmall.bean.UmsMemberReceiveAddress;
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
public interface UserAddressMapper {

    /**
     * 根据用户id查询收货地址
     * @param memberId
     * @return
     */
    @Select("select * from ums_member_receive_address where member_id=#{memberId}")
    public List<UmsMemberReceiveAddress> selectAddressByMemberId(@Param("memberId") String memberId);

}
