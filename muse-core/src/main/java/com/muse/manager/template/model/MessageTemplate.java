package com.muse.manager.template.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
** @Author: RyouA
** @Date: 2020/11/5
**/
@ApiModel(value="com-muse-manager-template-model-MessageTemplate")
@Getter
@Setter
@ToString
public class MessageTemplate implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long uid;

    /**
    * 模板名称
    */
    @ApiModelProperty(value="模板名称")
    private String name;

    /**
    * 模板类型 1：短信 2：邮件 3：微信小程序
    */
    @ApiModelProperty(value="模板类型 1：短信 2：邮件 3：微信小程序")
    private Integer type;

    /**
    * 状态 1：待审核 2：审核通过 3：审核未通过
    */
    @ApiModelProperty(value="状态 1：待审核 2：审核通过 3：审核未通过")
    private Integer status;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    @ApiModelProperty(value="")
    private Boolean valid;

    @ApiModelProperty(value="")
    private String description;

    /**
    * 模板内容
    */
    @ApiModelProperty(value="模板内容")
    private String content;

    private static final long serialVersionUID = 1L;
}