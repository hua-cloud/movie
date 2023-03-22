package com.cust.movie.mapper;

import com.cust.movie.entity.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//该注解表示标注当前的类是一个测试类
@SpringBootTest
//此注解表示的是启动这个单元测试类，需要传递一个参数
@RunWith(SpringRunner.class)
public class TicketMapperTests {
    @Autowired
    private TicketMapper ticketMapper;

    @Test
    public void findTicketById() {
        Integer id = 100006;
        Ticket ticket = ticketMapper.findTicketById(id);
        System.out.println(ticket.getTitle());
    }

    @Test
    public void testUpdateTicketNum () {
        Integer newNum = 100;
        Integer mid = 100006;
        Integer rows = ticketMapper.updateTicketNum(mid,newNum);
        System.out.println(rows);
    }
}
