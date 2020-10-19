package com.muse.send.interceptor;

import com.muse.config.JwtIgnore;
import com.muse.exception.MuseException;
import com.muse.model.ResultCode;
import com.muse.send.util.TokenUtil;
import com.muse.threadLocal.UserLocal;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器, 获取token来保存当前用户id
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Slf4j
@Component
public class HttpInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private Audience audience;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 排除带JwtIgnore注解的接口
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取请求头信息authorization信息
        final String authHeader = request.getHeader(TokenUtil.AUTH_HEADER_KEY);
        log.info("## authHeader= {}", authHeader);

        if (StringUtils.isBlank(authHeader)) {
            log.info("###=========用户未登录，请先登录===============###");
            throw new MuseException(ResultCode.USER_NOT_LOGGED_IN);        }

        if(audience == null){
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            audience = (Audience) factory.getBean("audience");
        }

        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        Claims claims = TokenUtil.parseJWT(authHeader, audience.getBase64Secret());
        UserLocal.setUserId(Long.parseLong(TokenUtil.getUserId(authHeader, audience.getBase64Secret())));
        return true;
    }

}
