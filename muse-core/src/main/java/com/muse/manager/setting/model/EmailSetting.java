package com.muse.manager.setting.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 邮箱设置
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@Getter
@Setter
public class EmailSetting {
    /**
     * Id
     */
    private Long id;

    /**
     * 绑定的用户id
     */
    private Long uid;

    /**
     * 邮箱名称
     */
    private String name;
    /**
     * 邮箱服务器地址
     */
    private String address;
    /**
     * 邮箱服务器端口
     */
    private String port;
    /**
     * 发件人
     */
    private String account;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 是否开启SSL
     */
    private Boolean isSSL;
    /**
     * 是否开启TLS
     */
    private Boolean isTLS;
    /**
     * 备注
     */
    private String remark;

    private Date createTime;
    private Date updateTime;
    private Boolean valid;
}
