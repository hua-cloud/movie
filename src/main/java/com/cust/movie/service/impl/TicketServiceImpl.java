package com.cust.movie.service.impl;

import com.cust.movie.entity.Ticket;
import com.cust.movie.mapper.TicketMapper;
import com.cust.movie.service.ITicketService;
import com.cust.movie.service.ex.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public Ticket findTicketById(Integer mid) {
        // 根据传入的参数id，调用持久层的方法进行查询对应的电影票数据
        Ticket ticket = ticketMapper.findTicketById(mid);
        // 判断查询结果是否为空
        if (ticket == null) {
            // 是:抛出TicketNotFoundException
            throw new TicketNotFoundException("尝试访问的数据不存在");
        }
        // 将查询结果中的部分属性设置为null
        ticket.setCreatedUser(null);
        ticket.setCreatedTime(null);
        ticket.setModifiedUser(null);
        ticket.setModifiedTime(null);
        // 返回查询结果
        return ticket;
    }
}
