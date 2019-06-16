package com.xc.gituse.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author chujian
 * @ClassName User
 * @Description 功能描述
 * @date 2019/6/13 17:22
 */
@Data
@ToString
@Entity
@Table(name = "t_jpa_user", schema = "wheel-making", catalog = "")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "rid")
    private Integer rid;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Role role;

}
    