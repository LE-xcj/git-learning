package com.xc.gituse.controller;

import com.xc.gituse.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chujian
 * @ClassName UserController
 * @Description 功能描述
 * @date 2019/6/13 17:27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/queryUserById")
    public User queryUserById (String id) {

        return new User();
    }
}
    