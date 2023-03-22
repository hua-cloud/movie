package com.cust.movie.mapper;

import com.cust.movie.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

//该注解表示标注当前的类是一个测试类
@SpringBootTest
//此注解表示的是启动这个单元测试类，需要传递一个参数
@RunWith(SpringRunner.class)
public class OrderMapperTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsert () {
        Order order = new Order();
        order.setUid(4);
        order.setMid(100003);
        order.setAmount(2);
        order.setTicketStatus(0);
        order.setCreatedUser("admin");
        order.setCreatedTime(new Date());

        Integer rows = orderMapper.insert(order);
        System.out.println(rows);
    }

    @Test
    public void testFindOrdersById () {
        Integer uid = 9;
        List<Order> orders = orderMapper.findOrdersById(uid);
        for ( Order order : orders ) {
            System.out.println(order);
        }
    }
}
