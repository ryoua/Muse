package com.ryoua.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
public class AuthFilter implements GatewayFilter, Ordered {

    private static final String AUTHORIZATION_BEAR = "";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
//                    Long startTime = exchange.getAttributes();
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
