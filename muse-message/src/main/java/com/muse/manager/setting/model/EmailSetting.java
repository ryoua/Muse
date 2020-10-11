package com.muse.manager.setting.model;


import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
public class EmailSetting {
    private long id;
    private Long uid;
    private String name;
    private String address;
    private String port;
    private String account;
    private String username;
    private String password;
    private boolean isSSL;
    private boolean isTLS;
    private Date createTime;
    private Date updateTime;
    private boolean valid;
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSSL() {
        return isSSL;
    }

    public void setSSL(boolean SSL) {
        isSSL = SSL;
    }

    public boolean isTLS() {
        return isTLS;
    }

    public void setTLS(boolean TLS) {
        isTLS = TLS;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
