package com.xc.gituse.dao;

import com.xc.gituse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chujian
 * @ClassName UserDao
 * @Description 功能描述
 * 参数T：当前需要映射的实体
 * 参数TD： 当前映射的实体中的OID类型
 * @date 2019/6/14 21:42
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
