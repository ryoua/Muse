package com.muse.manager.message.model;

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
@ApiModel(value="com-muse-manager-message-model-MessageSendDetail")
@Getter
@Setter
@ToString
public class MessageSendDetail implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 状态
    */
    @ApiModelProperty(value="状态")
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
    * 消息内容
    */
    @ApiModelProperty(value="消息内容")
    private String message;

    /**
    * 接受者名称
    */
    @ApiModelProperty(value="接受者名称")
    private String receiver;

    private static final long serialVersionUID = 1L;
}