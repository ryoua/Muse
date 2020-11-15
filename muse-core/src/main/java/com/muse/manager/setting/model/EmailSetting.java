package com.muse.manager.setting.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
** @Author: RyouA
** @Date: 2020/11/15
**/
/**
    * 邮箱设置表
    */
@ApiModel(value="com-muse-manager-setting-model-EmailSetting")
@Getter
@Setter
@ToString
public class EmailSetting implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long uid;

    /**
    * 名称
    */
    @ApiModelProperty(value="名称")
    private String name;

    /**
    * 邮件服务器地址
    */
    @ApiModelProperty(value="邮件服务器地址")
    private String address;

    /**
    * 邮件服务器的端口
    */
    @ApiModelProperty(value="邮件服务器的端口")
    private String port;

    /**
    * 发件人
    */
    @ApiModelProperty(value="发件人")
    private String account;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 是否开启TLS
    */
    @ApiModelProperty(value="是否开启TLS")
    private Boolean isTls;

    /**
    * 是否开启SSL
    */
    @ApiModelProperty(value="是否开启SSL")
    private Boolean isSsl;

    /**
    * 密码

    */
    @ApiModelProperty(value="密码,")
    private String password;

    @ApiModelProperty(value="")
    private Boolean valid;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    @ApiModelProperty(value="")
    private String description;

    private static final long serialVersionUID = 1L;
}