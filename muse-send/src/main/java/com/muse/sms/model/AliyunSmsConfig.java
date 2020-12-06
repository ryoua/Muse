package com.muse.sms.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 阿里云短信配置文件
 * * @Author: RyouA
 * * @Date: 2020/12/3
 **/
@Getter
@Setter
public class AliyunSmsConfig {
    private String accessKeyId;
    private String accessKeySecret;
    private String signName;
    private String templateId;
}
