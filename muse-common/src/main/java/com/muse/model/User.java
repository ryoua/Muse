package com.muse.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/14
 **/
@Getter
@Setter
public class User {
    private long id;
    private String salt;
    private String username;
    private String password;
    private Date lastLogin;
    private Date createTime;
    private Date updateTime;
    private boolean valid;
}
