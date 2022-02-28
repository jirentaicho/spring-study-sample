package com.volkruss.misaka.aop;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public abstract class AbstractInterceptor implements HandlerInterceptor {

    protected final String getHandlerMethodDesc(Object handler){
        String result = "";
        if(handler instanceof HandlerMethod){
            result = ((HandlerMethod)handler).toString();
        }
        return result;
    }
}
