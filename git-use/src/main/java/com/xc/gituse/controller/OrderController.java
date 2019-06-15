package com.xc.gituse.controller;

import com.xc.gituse.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chujian
 * @ClassName OrderController
 * @Description 功能描述
 * @date 2019/6/14 21:53
 */
@RestController
@RequestMapping("/order")
@Slf4j // 日志输出
public class OrderController {

    public void createOrder (Order order) {

        // lombok集成了日志输出框架，使用注解就可以通过log对象进行日志输出
        log.info("order info : ", order);
    }
}
    