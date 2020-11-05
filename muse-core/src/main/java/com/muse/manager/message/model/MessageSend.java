package com.muse.manager.message.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/5
 **/
@ApiModel(value = "com-muse-manager-message-model-MessageSend")
@Getter
@Setter
@ToString
public class MessageSend implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    @ApiModelProperty(value = "")
    private Long uid;

    @ApiModelProperty(value = "")
    private String name;

    @ApiModelProperty(value = "")
    private Integer type;

    /**
     * 消息类型
     */
    @ApiModelProperty(value = "消息类型")
    private Integer messageType;

    /**
     * 是否选用模板，默认选用
     */
    @ApiModelProperty(value = "是否选用模板，默认选用")
    private Boolean messageIsTemplate;

    /**
     * 接收者类型
     */
    @ApiModelProperty(value = "接收者类型")
    private Integer receiverType;

    /**
     * 是否选用模板，默认选用
     */
    @ApiModelProperty(value = "是否选用模板，默认选用")
    private Boolean receiverIsTemplate;

    /**
     * 执行步骤
     */
    @ApiModelProperty(value = "执行步骤")
    private Integer step;

    @ApiModelProperty(value = "")
    private Date createTime;

    @ApiModelProperty(value = "")
    private Date updateTime;

    @ApiModelProperty(value = "")
    private Boolean valid;

    @ApiModelProperty(value = "")
    private String description;

    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String message;

    /**
     * 接收者
     */
    @ApiModelProperty(value = "接收者")
    private String receiver;

    private static final long serialVersionUID = 1L;
}