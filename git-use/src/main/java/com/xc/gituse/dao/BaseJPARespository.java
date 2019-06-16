package com.xc.gituse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author chujian
 * @ClassName BaseJPARespository
 * @Description 功能描述
 * @date 2019/6/16 20:07
 */
@NoRepositoryBean       //是为了避免SpringDataJPA自动实例化才添加的。
public interface BaseJPARespository<T> extends
        JpaRepository<T,Long>,
        JpaSpecificationExecutor<T>{
}
