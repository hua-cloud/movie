package com.cust.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @EnableWebMvc 注解用于启用完全手动控制 Spring MVC 配置的方式，
 * 它会覆盖 Spring Boot 的自动配置。默认情况下，Spring Boot 提供了自动配置来处理静态资源，
 * 而不需要显式地启用,因为在启动类中启用了该注解，所以需要在配置类中显式地声明静态资源的处理器，并添加适当的请求映射：
 * 否则会报错：no mapping for xxx.html
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    // 定义静态资源的类路径位置
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/",   // 存放一些特定于框架的资源
            "classpath:/resources/",           // 存放在src/main/resources目录下的资源
            "classpath:/static/",              // 存放静态资源文件，如CSS、JavaScript、图片等
            "classpath:/public/"               // 存放公共资源，如HTML页面等
    };

    /**
     * 注意：使用 @EnableWebMvc 注解后，你需要手动处理所有的 Spring MVC 配置，
     * 包括静态资源的处理器。确保在配置类中添加适当的处理器和请求映射，以正确处理你的静态资源。
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置 WebJars 资源处理器，处理 /webjars/** 的请求
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }

        // 配置默认的资源处理器，处理其他的资源请求
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**")
                    .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        }
    }
}
