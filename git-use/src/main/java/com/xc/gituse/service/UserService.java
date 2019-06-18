package com.xc.gituse.service;

import com.xc.gituse.entity.User;
import com.xc.gituse.entity.vo.UserVO;

import java.util.List;

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
    int updateUserById(User user) throws Exception;


    List<User> findByName(String name);
    List<User> findByNameAndAge(String name, int age);
    List<User> findByNameLike(String name);



    List<User> listUsersByName(String name);
    List<User> listUsersByNameSQL(String name);
    void updateUserById( String name, Integer id);


    List<User> listUsersSort(List<String> properties);
    UserVO listUserByPage(int page, int size);


    UserVO listUserByJpaResposity(int page, int size);
    List<User> listUserByJpaOrder(List<String> properties);


    void insertOneToMany(User user);
    List<User> testLaszy();
    List<User> testNoneLaszy();
    User findUserAndOrder(Integer id);

    UserVO userSpecQuery(User param);
}
    