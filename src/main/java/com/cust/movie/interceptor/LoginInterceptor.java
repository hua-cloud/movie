package com.cust.movie.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 一个拦截器类，实现了Spring MVC框架提供的HandlerInterceptor接口
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 检测全局session域对象中是否含有key为"uid"的键值对，若有则放行，若没有则重定向到登录界面
     * @param request 请求域对象
     * @param response 相应对象
     * @param handler 处理器
     * @return 返回值为true则表示放行当前的请求，若返回值为false则表示拦截当前请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //用HttpServletRequest对象来获取session域对象，再使用session域对象获取到key为"uid"的键值对中的value
        Object object = request.getSession().getAttribute("uid");
        if (object == null) {
            // 说明用户没有登录过系统，则重定向到login.html页面
            // response.sendRedirect("/web/login.html");
            // 结束了后续的调用，拦截请求
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.debug("当前请求被拦截");
            return false;
        }
        // 请求放行
        return true;
    }
}
