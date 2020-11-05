package com.muse.manager.template.model;

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
@ApiModel(value = "com-muse-manager-template-model-ReceiverTemplate")
@Getter
@Setter
@ToString
public class ReceiverTemplate implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    @ApiModelProperty(value = "")
    private Long uid;

    /**
     * 模板名称
     */
    @ApiModelProperty(value = "模板名称")
    private String name;

    /**
     * 模板类型 1：字符串 2：文件 3：SQL
     */
    @ApiModelProperty(value = "模板类型 1：字符串 2：文件 3：SQL")
    private Integer type;

    /**
     * 接收者类型 1：uid 2：phone 3：did
     */
    @ApiModelProperty(value = "接收者类型 1：uid 2：phone 3：did")
    private Integer receiverType;

    /**
     * 状态 1：待审核 2：审核通过 3：审核未通过
     */
    @ApiModelProperty(value = "状态 1：待审核 2：审核通过 3：审核未通过")
    private Integer status;

    @ApiModelProperty(value = "")
    private Date createTime;

    @ApiModelProperty(value = "")
    private Date updateTime;

    @ApiModelProperty(value = "")
    private Boolean valid;

    @ApiModelProperty(value = "")
    private String description;

    /**
     * 模板内容
     */
    @ApiModelProperty(value = "模板内容")
    private String content;

    private static final long serialVersionUID = 1L;
}