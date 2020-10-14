package com.muse.send.email.model;

import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/14
 **/
@Getter
@Setter
public class EmailSetting {
    private String host;
    private String username;
    private String password;
    private String protocol;
    private boolean auth;
    private int port;
    private String sendMail;
    private String sendName;
    private boolean enable;
    private boolean required;
    private String defaultEncoding;
    private String from;
}
