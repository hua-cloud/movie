package com.cust.movie.config;

import com.cust.movie.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建自定义的拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();

        // 配置白名单:存放在List集合
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        // patterns.add("/web/index.html");
        patterns.add("/user/login");
        patterns.add("/user/reg");
        patterns.add("/swagger**/**");
        patterns.add("/webjars/**");
        patterns.add("/v3/**");
        patterns.add("doc.html");

        // 完成拦截器的注册
       registry.addInterceptor(interceptor)
               .addPathPatterns("/**") // 拦截全部请求
               .excludePathPatterns(patterns);// 排除白名单中的部分请求
    }
}
