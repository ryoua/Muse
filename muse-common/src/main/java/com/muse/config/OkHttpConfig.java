package com.muse.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/12
 **/
@Slf4j
@Component
public class OkHttpConfig {
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient().newBuilder().retryOnConnectionFailure(false).connectionPool(pool())
                .connectTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS)
                .build();

    }

    @Bean
    public ConnectionPool pool() {
        return new ConnectionPool(50, 5, TimeUnit.MINUTES);
    }
}
