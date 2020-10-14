package com.muse.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
@Configuration
public class SpringConfig implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringConfig.applicationContext = applicationContext;
    }

    public  static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
