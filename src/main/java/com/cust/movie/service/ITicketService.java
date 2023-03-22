package com.cust.movie.service;

import com.cust.movie.entity.Ticket;

/** 查询电影票详情的业务层接口 */
public interface ITicketService {
    /**
     * 根据电影id查询电影票详情
     * @param mid 电影id
     * @return 匹配的电影票详情，如果没有匹配的则返回null
     */
    Ticket findTicketById(Integer mid);
}
