package com.xc.gituse.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @author chujian
 * @ClassName User
 * @Description 功能描述
 * @date 2019/6/13 17:22
 */
@Data
@ToString
@Entity
public class User {
    private Integer id;
    private String name;
    private int age;
    private String sex;

}
    