package com.cust.movie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//MapperScan注解指定当前项目中的Mapper接口路径的位置，在项目启动的时候会自动加载所有的接口
@MapperScan("com.cust.movie.mapper")
@EnableWebMvc
public class MovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
}
