package com.muse.dispatch;

import com.muse.dispatch.consumer.EmailEventConsumer;
import com.muse.dispatch.consumer.SmsEventConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
@Configuration
public class DispatchConfig {

    @Bean
    public EmailEventConsumer emailEventConsumer() {
        return new EmailEventConsumer();
    }

    @Bean
    public SmsEventConsumer smsEventConsumer() {
        return new SmsEventConsumer();
    }
}
