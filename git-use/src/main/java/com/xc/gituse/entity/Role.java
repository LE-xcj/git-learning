package com.xc.gituse.entity;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chujian
 * @ClassName TJpaRole
 * @Description 功能描述
 * @date 2019/6/16 21:57
 */
@Entity
@Data
@Table(name = "t_jpa_role", schema = "wheel-making", catalog = "")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
    