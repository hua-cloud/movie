package com.cust.movie.controller;

import com.cust.movie.entity.Order;
import com.cust.movie.service.IOrderService;
import com.cust.movie.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(tags = "用户订单数据处理模块")
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{

    @Autowired
    IOrderService orderService;


    @GetMapping("/addOrder")
    @ApiOperation("用户下单")
    public JsonResult<Void> addOrder (@RequestParam("mid") Integer mid, @RequestParam("amount") Integer amount, HttpSession session) {

        Order order = new Order();
        // 从session域对象中获取到当前登录用户的用户名和uid（存入session域对象中的数据，实现全局参数共享）
        String username = getUsernameFromSession(session);
        Integer uid = getUidFromSession(session);

        // 补全相关数据
        order.setUid(uid);
        order.setMid(mid);
        order.setAmount(amount);
        orderService.placeOrder(order,username);
        return new JsonResult<Void>(OK);
    }

    @GetMapping("/getOrder")
    @ApiOperation("获取当前用户订单信息")
    public JsonResult<List<Order>> getUserAllOrders (HttpSession session) {

        // 获取到当前登录用户的uid
        Integer uid = getUidFromSession(session);
        // 根据uid执行查询操作
        List<Order> data = orderService.getUserAllOrders(uid);
        return new JsonResult<List<Order>>(OK,data);
    }

}
