package com.cust.movie.service;

import com.cust.movie.entity.Order;

import java.util.List;

/**
 * 订单信息处理功能模块的业务层接口
 */
public interface IOrderService {

    /**
     * 新增用户订单信息
     * @param order
     * @param username
     */
    void placeOrder (Order order,String username);

    /**
     * 根据用户的uid查询所有订单信息
     * @param uid 用户uid
     * @return 用户所有订单记录
     */
    List<Order> getUserAllOrders (Integer uid);
}
