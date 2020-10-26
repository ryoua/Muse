package com.muse.common.interceptor;

import com.muse.common.threadLocal.UserLocal;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserLocal.setUserId(1L);
        return true;
    }
}
