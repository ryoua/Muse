package com.muse.setting.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Getter
@Setter
public class EmailSetting {
    private Long id;
    private Long uid;
    private String name;
    private String address;
    private String port;
    private String account;
    private String username;
    private String password;
    private Integer isSSL;
    private Integer isTLS;
    private Date createTime;
    private Date updateTime;
    private Integer valid;
    private String remark;
}
