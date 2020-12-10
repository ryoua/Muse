package com.muse.email.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * 短信发送线程池
 * * @Author: RyouA
 * * @Date: 2020/11/29
 **/
@Configuration
public class SmsSendThreadPool {
    private static final int CORE_POOL_SIZE = 6;
    private static final int MAX_POOL_SIZE = 12;
    private static final int KEEP_ALIVE_TIME = 60;

    private static ThreadPoolExecutor emailExecutor() {
        return new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("smsSender- ").build());
    }

    public static <V> Future<V> submit(Callable<V> task) {
        return emailExecutor().submit(task);
    }

    public static void execute(Runnable task) {
        emailExecutor().execute(task);
    }
}
