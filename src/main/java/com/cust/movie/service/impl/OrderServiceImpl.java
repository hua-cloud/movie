package com.cust.movie.service.impl;

import com.cust.movie.entity.Order;
import com.cust.movie.entity.Ticket;
import com.cust.movie.entity.User;
import com.cust.movie.mapper.OrderMapper;
import com.cust.movie.mapper.TicketMapper;
import com.cust.movie.mapper.UserMapper;
import com.cust.movie.service.IOrderService;
import com.cust.movie.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TicketMapper ticketMapper;
    @Autowired
    UserMapper userMapper;


    /**
     * 新增用户订单信息
     * @param order
     */
    @Override
    public void placeOrder(Order order,String username) {
        Integer mid = order.getMid();
        // 调用findTicketById方法，判断该电影票是否存在
        Ticket ticket = ticketMapper.findTicketById(mid);
        // 判断ticket是否为空，若为空则表明该电影票信息不存在，抛出异常
        if (ticket == null) {
            throw new TicketNotFoundException("该电影票信息不存在！");
        }
        // 获取该电影票的剩余数量
        Integer remainNum = ticket.getNum();
        // 获取到用户要购买的数量
        Integer amount = order.getAmount();
        // 求得购买后的电影票的新的剩余数量
        Integer newNum = remainNum - amount;
        // 判断电影票的剩余数量是否大于或等于用户要购买的数量，若余票不足则抛出异常
        if (newNum<0) {
            throw new TicketNumException("余票不足！");
        }

        // 补全数据，将票的状态默认设置为1，表明正常出票，管理员后续可以根据实际情况进行修改
        order.setTicketStatus(1);
        // 补全数据: 4个日志字段信息
        order.setCreatedUser(username);
        order.setModifiedUser(username);
        Date date = new Date();
        order.setCreatedTime(date);
        order.setModifiedTime(date);

        // 核心业务逻辑
        // 1.更新该电影票的剩余数量
        ticketMapper.updateTicketNum(mid,newNum);
        // 2.新增一条订单记录
        Integer rows = orderMapper.insert(order);
        // 若返回值不为1，则抛出异常
        if (rows != 1) {
            throw new OrderInsertException("新增订单信息时出现未知异常！");
        }

    }

    /**
     * 根据用户的uid获取到该用户的所有订单记录
     * @param uid 用户uid
     * @return
     */
    @Override
    public List<Order> getUserAllOrders(Integer uid) {
        // 判断用户是否存在
        User result = userMapper.findByUid(uid);
        if (result == null) {
            throw new UserNotFoundException("用户不存在");
        }
        // 查询用户的所有订单记录
        List<Order> orders = orderMapper.findOrdersById(uid);
        return orders;
    }
}
