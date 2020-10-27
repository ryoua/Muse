package com.muse.manager.template.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Getter
@Setter
public class Template {
    private long id;
    private long uid;
    private String name;
    /**
     * 状态
     * 0: 待审核
     * 1: 审核通过
     * 2: 审核不通过
     */
    private int status;

    /**
     * 审核失败的原因
     */
    private String failReason;

    protected Date createTime;
    protected Date updateTime;
    protected Boolean valid;
}
