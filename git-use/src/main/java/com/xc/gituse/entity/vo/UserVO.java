package com.xc.gituse.entity.vo;

import com.xc.gituse.entity.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author chujian
 * @ClassName UserVO
 * @Description 功能描述
 * @date 2019/6/16 19:22
 */

@Data
@ToString
public class UserVO {

    private List<User> users;

    private int totalPage;

    private long totalE;


    private int currentPage;



}
    