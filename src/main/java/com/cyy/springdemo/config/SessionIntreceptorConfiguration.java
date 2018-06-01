package com.cyy.springdemo.config;

import com.cyy.springdemo.Intreceptor.SessionUserIntreceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SessionIntreceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionUserIntreceptor()).addPathPatterns("/**");
    }
}
