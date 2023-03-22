package com.cust.movie.service;

import com.cust.movie.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//该注解表示标注当前的类是一个测试类
@SpringBootTest
//此注解表示的是启动这个单元测试类，需要传递一个参数
@RunWith(SpringRunner.class)
public class OrderServiceTests {

    @Autowired
    IOrderService orderService;

    @Test
    public void testPlaceOrder () {
        String username = "test02";
        Order order = new Order();
        order.setUid(3);
        order.setMid(100006);
        order.setAmount(2);
        orderService.placeOrder(order,username);
    }
}
