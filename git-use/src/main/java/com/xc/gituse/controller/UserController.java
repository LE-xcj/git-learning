package com.xc.gituse.controller;

import com.xc.gituse.entity.User;
import com.xc.gituse.entity.dto.UserDTO;
import com.xc.gituse.entity.vo.UserVO;
import com.xc.gituse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chujian
 * @ClassName UserController
 * @Description 功能描述
 * @date 2019/6/13 17:27
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserById")
    public User queryUserById (Integer id) throws Exception {
        User user = userService.queryUserById(id);
        return user;
    }


    @RequestMapping("/createUser")
    public int createUser(User user) throws Exception {
        int flag = userService.createUser(user);
        return flag;
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(Integer id) throws Exception {
        int i = userService.deleteUser(id);
    }

    @RequestMapping("/updateUserById")
    public void updateUserById(User user) throws Exception {
        int i = userService.updateUserById(user);

    }


    @RequestMapping("/findByName")
    public List<User> findByName(String name) {

        return userService.findByName(name);
    }

    @RequestMapping("/findByNameAndAge")
    public List<User> findByNameAndAge(String name, int age) {
        return userService.findByNameAndAge(name, age);
    }

    @RequestMapping("/findByNameLike")
    public List<User> findByNameLike(String name) {
        return userService.findByNameLike(name);
    }


    @RequestMapping("/listUsersByName2")
    List<User> listUsersByName(String name) {

        return userService.listUsersByName(name);
    }

    @RequestMapping("/listUsersByNameSQL")
    List<User> listUsersByNameSQL(String name) {
        return userService.listUsersByNameSQL(name);
    }

    @RequestMapping("/updateUserById2")
    void updateUserById( String name, Integer id) {
        userService.updateUserById(name, id);

    }



    @RequestMapping("/listUsersSort")
    List<User> listUsersSort(UserDTO dto) {

        return userService.listUsersSort(dto.getProperties());
    }

    @RequestMapping("/listUserByPage")
    UserVO listUserByPage(int page, int size){

        return userService.listUserByPage(page, size);

    }

    @RequestMapping("/listUserByJpaResposity")
    public UserVO listUserByJpaResposity(int page, int size) {
        return userService.listUserByJpaResposity(page, size);
    }

    @RequestMapping("/listUserByJpaOrder")
    public List<User> listUserByJpaOrder(UserDTO dto) {
        return userService.listUserByJpaOrder(dto.getProperties());
    }

    @RequestMapping("/insertOneToMany")
    public void insertOneToMany() {

        userService.insertOneToMany();
    }

}
    