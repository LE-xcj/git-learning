package com.xc.gituse.dao;

import com.xc.gituse.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author chujian
 * @ClassName UserRespositoryQueryDao
 * @Description 功能描述
 * @date 2019/6/16 15:02
 */
public interface UserRespositoryQueryDao extends Repository<User, Integer>{

    /**
     * 这里使用jpa提供的简化SQL编写
     * 省略的一些操作的信息，但是一定要注意
     * from 后面跟着的是实体类的名称（应该可以定义）
     * @param name
     * @return
     */
    @Query("FROM User WHERE name = ?1")
    List<User> listUsersByName(String name);

    /**
     * 原生SQL进行查询
     * 然后通过参数下标进行绑定
     * nativeQuery默认是false
     * @param name
     * @return
     */
    @Query(value = "SELECT * FROM t_jpa_user WHERE name = ?1", nativeQuery = true)
    List<User> listUsersByNameSQL(String name);


    @Modifying      // 写操作都加上这个注解
    @Transactional  // 更新操作需要添加事务注解， 否则调用时会出异常
    @Query("UPDATE User SET name = ?1 WHERE id = ?2")
    int updateUserById( String name, Integer id);
}
