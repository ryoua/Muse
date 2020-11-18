package com.muse.send.email.config;

import com.muse.manager.setting.model.EmailSetting;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/11
 **/
//@Configuration
public class EmailConfig {
    private JavaMailSenderImpl javaMailSender;

//    @Bean
    public JavaMailSender config(EmailSetting emailSetting) {
        javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(emailSetting.getAddress());
        javaMailSender.setUsername(emailSetting.getUsername());
        javaMailSender.setPassword(emailSetting.getPassword());

        return javaMailSender;
    }
}
