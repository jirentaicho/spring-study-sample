package com.volkruss.misaka.config;

import com.volkruss.misaka.aop.AuthDeleteInterceptor;
import com.volkruss.misaka.aop.AuthUpdateInterceptor;
import com.volkruss.misaka.aop.RequestTracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private RequestTracking requestTracking;

    @Autowired
    private AuthUpdateInterceptor authInterceptor;

    @Autowired
    private AuthDeleteInterceptor authDeleteInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTracking)
                .addPathPatterns("/")
                .addPathPatterns("/track");
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/update");
        registry.addInterceptor(authDeleteInterceptor)
                .addPathPatterns("/delete");
    }
}
