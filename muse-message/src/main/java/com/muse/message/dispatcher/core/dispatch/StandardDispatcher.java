package com.muse.message.dispatcher.core.dispatch;

import com.muse.message.dispatcher.core.pipeline.Pipeline;
import com.muse.message.dispatcher.core.pipeline.StandardPipeline;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
@Component
public class StandardDispatcher {
//    @Bean
//    Pipeline pipeline() {
//        return new StandardPipeline();
//    }

    public void dispatch(Object o) {
//        pipeline.invoke();
    }
}
