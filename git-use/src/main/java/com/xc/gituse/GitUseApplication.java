package com.xc.gituse;

import com.xc.gituse.config.GitUseApplicationConfig;
import org.springframework.boot.SpringApplication;

/**
 * @author chujian
 * @ClassName GitUseApplication
 * @Description 功能描述
 * @date 2019/6/16 13:43
 */
public class GitUseApplication {

    public static void main(String[] args){
        SpringApplication.run(GitUseApplicationConfig.class, args);
    }
}
    