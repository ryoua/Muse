package com.muse.manager.setting.model;

import com.muse.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;


/**
 * 邮箱设置
 * * @Author: RyouA
 * * @Date: 2020/10/22
 **/
@Getter
@Setter

public class EmailSetting extends BaseModel {
    private long id;

    private long uid;

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
