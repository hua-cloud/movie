package com.cust.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger3配置类
 */
@Configuration
// 开启swagger3
@EnableOpenApi
public class Swagger3Config {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // true 启用 ,false 禁用 (生产环境中要禁用)
                .enable(true)
                .select()
                // 扫描controller包下的所有API
                .apis(RequestHandlerSelectors.basePackage("com.cust.movie.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * API 文档上半部分展示信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("movie线上购票系统接口文档")
                .contact(new Contact("hua","https://github.com/hua-cloud","nachoneco6@gmail.com"))
                .version("1.0")
                .build();
    }
}
