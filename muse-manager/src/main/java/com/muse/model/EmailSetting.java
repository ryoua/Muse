package com.muse.model;

import lombok.Getter;
import lombok.Setter;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/19
 **/
@Getter
@Setter
public class EmailSetting extends BaseModel {
    private Long id;
    private String name;
    private String address;
    private String port;
    private String account;
    private String username;
    private String password;
    private Boolean isSSL;
    private Boolean isTLS;
    private String remark;
}
