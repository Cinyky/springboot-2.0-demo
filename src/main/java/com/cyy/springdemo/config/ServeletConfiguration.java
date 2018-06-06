package com.cyy.springdemo.config;

import com.cyy.springdemo.servelet.TestServelet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ServletComponentScan
public class ServeletConfiguration {
    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        return new ServletRegistrationBean(new TestServelet(),"/test");
    }

}
