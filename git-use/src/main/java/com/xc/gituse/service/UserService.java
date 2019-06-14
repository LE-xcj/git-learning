package com.xc.gituse.service;

import com.xc.gituse.entity.User;

/**
 * @author chujian
 * @ClassName UserService
 * @Description 功能描述
 * @date 2019/6/13 22:00
 */
public interface UserService {

    int createUser(User user) throws Exception;

    int deleteUser(Integer id) throws Exception;

    User queryUserById(Integer id) throws Exception;

}
    