package com.muse.message.send.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/6
 **/
@Configuration
public class EmailSendThreadPool {
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 20;
    private static final int WAIT_QUEUE_SIZE = 1024;
    private static final int KEEP_ALIVE_TIME = 60;

    @Bean("emailExecutor")
    public Executor emailExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(CORE_POOL_SIZE);
        threadPoolExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        threadPoolExecutor.setQueueCapacity(WAIT_QUEUE_SIZE);
        threadPoolExecutor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        threadPoolExecutor.setThreadNamePrefix("emailExecutor-");

        // 使用CallerRuns策略, 不丢弃任务, 使用调用线程去处理
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolExecutor.setAwaitTerminationSeconds(600);
        return threadPoolExecutor;
    }
}
