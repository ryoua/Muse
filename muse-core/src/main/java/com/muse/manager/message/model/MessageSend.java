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
** @Date: 2020/10/31
**/
@ApiModel(value="com-muse-manager-message-model-MessageSend")
@Getter
@Setter
@ToString
public class MessageSend implements Serializable {
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long uid;

    /**
    * 消息名称
    */
    @ApiModelProperty(value="消息名称")
    private String name;

    /**
    * 消息类型
    */
    @ApiModelProperty(value="消息类型")
    private Integer type;

    /**
    * 参数的模板id
    */
    @ApiModelProperty(value="参数的模板id")
    private Long paramTemplateId;

    /**
    * 接受者的模板id
    */
    @ApiModelProperty(value="接受者的模板id")
    private Long receiverTemplateId;

    /**
    * 状态, 0待发送
    */
    @ApiModelProperty(value="状态, 0待发送")
    private Integer status;

    /**
    * 处于哪一步, 默认0, 管理层,刚生成
    */
    @ApiModelProperty(value="处于哪一步, 默认0, 管理层,刚生成")
    private Integer step;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    @ApiModelProperty(value="")
    private Boolean valid;

    @ApiModelProperty(value="")
    private String remark;

    /**
    * 参数的json格式
    */
    @ApiModelProperty(value="参数的json格式")
    private String paramJson;

    /**
    * 接受者的json格式
    */
    @ApiModelProperty(value="接受者的json格式")
    private String receiverJson;

    private static final long serialVersionUID = 1L;
}