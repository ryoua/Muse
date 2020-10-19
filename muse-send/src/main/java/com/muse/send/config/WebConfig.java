package com.muse.send.config;

import com.muse.send.interceptor.HttpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private HttpInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor(interceptor).addPathPatterns("/api/**");
    }
}
