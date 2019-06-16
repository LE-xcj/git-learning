package com.xc.gituse.dao;

import com.xc.gituse.entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author chujian
 * @ClassName UserRepositoryDao
 * @Description 功能描述
 * @date 2019/6/16 14:46
 */
public interface UserRepositoryDao extends Repository<User, Integer> {

    /**
     * 根据姓名等值查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据姓名和年龄等值查询，两个条件是and的关系
     * @param name
     * @param age
     * @return
     */
    List<User> findByNameAndAge(String name, int age);

    /**
     * 根据名字模糊查询
     * @param name
     * @return
     */
    List<User> findByNameLike(String name);



}
