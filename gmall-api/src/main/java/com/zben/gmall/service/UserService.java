package com.zben.gmall.service;

import com.zben.gmall.bean.UmsMember;
import com.zben.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/11/30 0030 18:26
 */
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<UmsMember> getAllUsers();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UmsMember getUserById(String id);

    /**
     * 根据用户id查询收货地址
     * @param memberId
     * @return
     */
    List<UmsMemberReceiveAddress> getAddressByMemberId(String memberId);
}
