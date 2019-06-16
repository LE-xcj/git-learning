package com.xc.gituse.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chujian
 * @ClassName GitUseApplicationConfig
 * @Description 功能描述
 * @date 2019/6/16 13:59
 */

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.xc.gituse")
@EnableJpaRepositories(basePackages = "com.xc.gituse.dao")    //扫描 @Repository 注解；
@EntityScan(basePackages = "com.xc.gituse.entity")   //扫描 @Entity 注解；
public class GitUseApplicationConfig {


}
    