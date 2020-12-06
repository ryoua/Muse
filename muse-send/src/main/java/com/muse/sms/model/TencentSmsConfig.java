package com.muse.sms.model;

import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/3
 **/
@Getter
@Setter
public class TencentSmsConfig {
    private String appId;
    private String appKey;
    private String signName;
    private String templateId;
}
