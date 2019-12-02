package com.zben.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zben.gmall.bean.UmsMember;
import com.zben.gmall.bean.UmsMemberReceiveAddress;
import com.zben.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/11/30 0030 18:48
 */
@RestController
public class UserController {

    @Reference
    UserService userService;

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("getAllUsers")
    public List<UmsMember> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public UmsMember getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    /**
     * 根据用户id查询收货地址
     * @param memberId
     * @return
     */
    @GetMapping("/address/{memberId}")
    public List<UmsMemberReceiveAddress> getAddressByMemberId(@PathVariable String memberId) {
        return userService.getAddressByMemberId(memberId);
    }
}
