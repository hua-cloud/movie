package com.cust.movie.mapper;

import com.cust.movie.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    /**
     * 根据用户的uid查询该用户的所有订单信息
     * @param uid 用户uid
     * @return 用户所有的订单信息
     */
    List<Order> findOrdersById (Integer uid);

    /**
     * 新增订单信息
     * @param order
     * @return 受影响的行数
     */
    Integer insert (Order order);
}
