package com.muse.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/15
 **/
@Getter
@Setter
public class BaseModel {
    protected Date createTime;

    protected Date updateTime;

    protected Boolean valid;
}
