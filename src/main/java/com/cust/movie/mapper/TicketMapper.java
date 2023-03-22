package com.cust.movie.mapper;

import com.cust.movie.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMapper {
    /**
     * 根据电影id查询电影票详情
     * @param mid 电影id
     * @return 匹配的电影票详情，如果没有匹配的数据则返回null
     */
    Ticket findTicketById(Integer mid);

    /**
     * 根据电影票的id更新电影票的剩余数量
     * @param mid
     * @return 收到影响的行数
     */
    Integer updateTicketNum (Integer mid,Integer newNum);
}
