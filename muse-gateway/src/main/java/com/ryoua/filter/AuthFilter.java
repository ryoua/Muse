package com.ryoua.filter;

import com.ryoua.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.bouncycastle.cms.PasswordRecipient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
@Slf4j
@Configuration
public class AuthFilter implements GlobalFilter, Ordered {
    private static final String LOGIN_URL = "http://127.0.0.1:9005/api/auth/login";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(exchange.getRequest().getPath());
        List<String> tokens = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
        if (tokens == null || tokens.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        } else {
            Response response = OkHttpUtil.postJsonParams(LOGIN_URL, tokens.get(0));
            if (response.code() == HttpStatus.OK.value()) {
                exchange.getRequest().getHeaders().add("XXXXXXXXX", "111111111111");
                exchange.getResponse().setStatusCode(HttpStatus.OK);
            } else {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            }
        }
        exchange.getResponse().setComplete();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
