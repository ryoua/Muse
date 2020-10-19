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
public class Template {
    private long id;
    private long uid;
    private int type;
    private String name;
    private int sendCycleType;
    private String sendCycle;
    private int receiverIdType;
    private String body;
    private String creatorName;
    private String creatorPhone;
    private String messageBody;
    private Date updateTime;
    private Date createTime;
    private boolean valid;
    private String remark;
}