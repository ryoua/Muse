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
** @Date: 2020/11/21
**/
@ApiModel(value="com-muse-manager-setting-model-DatabaseSetting")
@Getter
@Setter
@ToString
public class DatabaseSetting implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long uid;

    /**
    * 数据库设置名称
    */
    @ApiModelProperty(value="数据库设置名称")
    private String name;

    /**
    * 类型，默认1 MySQL
    */
    @ApiModelProperty(value="类型，默认1 MySQL")
    private Integer type;

    /**
    * 数据库URL
    */
    @ApiModelProperty(value="数据库URL")
    private String url;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 密码，可以为空
    */
    @ApiModelProperty(value="密码，可以为空")
    private String password;

    /**
    * 是否可以正常连接，默认1
    */
    @ApiModelProperty(value="是否可以正常连接，默认1")
    private Boolean isOk;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    @ApiModelProperty(value="")
    private Byte valid;

    @ApiModelProperty(value="")
    private String remark;

    private static final long serialVersionUID = 1L;
}