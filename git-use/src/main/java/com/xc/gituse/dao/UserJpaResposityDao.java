package com.xc.gituse.dao;

import com.xc.gituse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chujian
 * @ClassName UserJpaResposityDao
 * @Description 功能描述
 * @date 2019/6/16 20:23
 */
public interface UserJpaResposityDao extends JpaRepository<User, Integer> {
}
    