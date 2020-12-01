package com.muse.sms.model;

import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/29
 **/
@Getter
@Setter
public class Sms {
    /**
     * 签名
     */
    private String sign ;
    /**
     * 模板
     */
    private String templateId;
    /**
     * 手机号
     */
    private String[] mobile;
    /**
     * 模板参数 {}
     */
    private String[] params;
}
