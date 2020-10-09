package com.muse.common.util;

import com.muse.common.config.SpringConfig;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
public class SpringUtil {
    public void registerQueueDynamic(String queueName) {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) SpringConfig.getApplicationContext();
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Queue.class);
        builder.addConstructorArgValue(queueName);
        defaultListableBeanFactory.registerBeanDefinition(queueName, builder.getBeanDefinition());
    }
}
