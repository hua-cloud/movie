package com.cust.movie.controller;

import com.cust.movie.entity.Ticket;
import com.cust.movie.service.ITicketService;
import com.cust.movie.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController extends BaseController{
    @Autowired
    private ITicketService ticketService;

    @GetMapping("/{mid}/detail")
    public JsonResult<Ticket> findTicketById(@PathVariable("mid") Integer mid){
        // 使用创建的业务层接口的对象来调用业务层的方法
        Ticket data = ticketService.findTicketById(mid);
        // 返回成功状态码及数据
        return new JsonResult<Ticket>(OK,data);
    }
}
