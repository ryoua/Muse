package com.muse.config.send;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/29
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "tencentcloud.sms")
public class TencentSmsConfig {
    /**
     * 短信应用 SDK AppID，SDK AppID 以1400开头
     */
    private int appId;

    /**
     * 短信应用SDK AppKey
     */
    private String appKey;

    /**
     * 需要发送短信的手机号码，可以定义多个手机号码
     */
    private String[] phoneNumbers;

    /**
     * 短信模板ID，需要在短信控制台中申请，我们查看自己的短信模板ID即可
     */
    private int templateId;

    /**
     *     签名，签名参数使用的是`签名内容`，而不是`签名ID`，真实的签名需要在短信控制台申请，这里按自己的来修改就好
     */
    private String smsSign;
}
