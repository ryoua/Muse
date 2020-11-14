package com.muse.dispatch.filter.blacklist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
** @Author: RyouA
** @Date: 2020/11/14
**/
/**
    * 黑名单表
    */
@ApiModel(value="com-muse-dispatch-filter-blacklist-model-BlackList")
@Getter
@Setter
@ToString
public class BlackList implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long uid;

    @ApiModelProperty(value="")
    private String name;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    @ApiModelProperty(value="")
    private Boolean valid;

    @ApiModelProperty(value="")
    private String description;

    private static final long serialVersionUID = 1L;
}