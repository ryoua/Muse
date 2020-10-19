package com.muse.send.interceptor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
    private String clientId;
    private String base64Secret;
    private String name;
    private Integer expiresSecond = 60 * 60 * 24 * 60;
}

