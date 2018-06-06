package com.cyy.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * ========================
 * Created with IntelliJ IDEA.
 * @Author： Cyy
 * @Date: 2018/6/6
 * @Time:  下午1:46
 * ========================
 */
@Configuration
public class ResourceConfiguration implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/web/resources/**").addResourceLocations("classpath:/static/");
    }
}
