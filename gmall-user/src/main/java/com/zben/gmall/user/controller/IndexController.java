package com.zben.gmall.user.controller;

import com.zben.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/11/30 0030 17:27
 */
@RestController
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String index() {
        return "hello";
    }

}
