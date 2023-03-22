package com.cust.movie.service;

import com.cust.movie.entity.Ticket;
import com.cust.movie.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//该注解表示标注当前的类是一个测试类
@SpringBootTest
//此注解表示的是启动这个单元测试类，需要传递一个参数
@RunWith(SpringRunner.class)
public class TicketServiceTests {
    @Autowired
    private ITicketService ticketService;

    @Test
    public void findTicketById() {
        try {
            Integer id = 100006;
            Ticket ticket = ticketService.findTicketById(id);
            System.out.println(ticket.getTitle());
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

}
