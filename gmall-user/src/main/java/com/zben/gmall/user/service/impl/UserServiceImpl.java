package com.zben.gmall.user.service.impl;

import com.zben.gmall.bean.UmsMember;
import com.zben.gmall.bean.UmsMemberReceiveAddress;
import com.zben.gmall.service.UserService;
import com.zben.gmall.user.mapper.UserAddressMapper;
import com.zben.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/11/30 0030 18:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UmsMember> getAllUsers() {
        return userMapper.selectAllUser();
    }

    @Override
    public UmsMember getUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<UmsMemberReceiveAddress> getAddressByMemberId(String memberId) {
        return userAddressMapper.selectAddressByMemberId(memberId);
    }
}
