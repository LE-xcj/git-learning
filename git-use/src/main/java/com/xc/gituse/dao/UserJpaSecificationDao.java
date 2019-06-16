package com.xc.gituse.dao;

import com.xc.gituse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author chujian
 * @ClassName UserJpaSecificationDao
 * @Description 功能描述
 * @date 2019/6/16 20:42
 */
public interface UserJpaSecificationDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}
    