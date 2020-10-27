package com.muse.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Getter
@Setter
public class BaseModel {
    protected Date createTime;

    @LastModifiedDate
    protected Date updateTime;

    protected Boolean valid;
}
