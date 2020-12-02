package com.muse.settings.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
** @Author: RyouA
** @Date: 2020/12/2
**/
/**
    * 服务设置表
    */
@ApiModel(value="com-muse-settings-model-ServiceSetting")
@Getter
@Setter
@ToString
public class ServiceSetting implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long uid;

    @ApiModelProperty(value="")
    private String factory;

    @ApiModelProperty(value="")
    private Integer type;

    @ApiModelProperty(value="")
    private String body;

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