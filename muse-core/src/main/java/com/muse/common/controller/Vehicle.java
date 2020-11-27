package com.muse.common.controller;

import lombok.Data;


public class Vehicle {
    //车架号
    private String vin;
    // 车主手机号
    private String phone;
    // 车主姓名
    private String name;
    // 所属车租车公司
    private Integer companyId;
    // 个人评分
    private Double score;
    //安装的设备列表imei,使用逗号分隔
    private String deviceNos;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDeviceNos() {
        return deviceNos;
    }

    public void setDeviceNos(String deviceNos) {
        this.deviceNos = deviceNos;
    }

    public Vehicle(String vin, String phone, String name, Integer companyId, Double score, String deviceNos) {
        this.vin = vin;
        this.phone = phone;
        this.name = name;
        this.companyId = companyId;
        this.score = score;
        this.deviceNos = deviceNos;
    }
}
