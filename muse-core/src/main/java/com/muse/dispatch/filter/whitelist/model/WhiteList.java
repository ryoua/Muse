package com.muse.dispatch.filter.whitelist.model;

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
    * 白名单表
    */
@ApiModel(value="com-muse-dispatch-filter-whitelist-model-WhiteList")
@Getter
@Setter
@ToString
public class WhiteList implements Serializable {
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