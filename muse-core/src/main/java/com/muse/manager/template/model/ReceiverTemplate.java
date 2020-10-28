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
** @Date: 2020/10/28
**/
@ApiModel(value="com-muse-manager-template-model-ReceiverTemplate")
@Getter
@Setter
@ToString
public class ReceiverTemplate implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long uid;

    /**
    * 模板名称
    */
    @ApiModelProperty(value="模板名称")
    private String name;

    /**
    * 状态, 默认0:待审核
    */
    @ApiModelProperty(value="状态, 默认0:待审核")
    private Integer status;

    /**
    * 模板类型
    */
    @ApiModelProperty(value="模板类型")
    private Integer templatetype;

    /**
    * 用户id类型
    */
    @ApiModelProperty(value="用户id类型")
    private Integer receivertype;

    /**
     * 模板内容
     */
    @ApiModelProperty(value="模板内容")
    private String content;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updatetime;

    /**
    * 逻辑删除
    */
    @ApiModelProperty(value="逻辑删除")
    private Boolean valid;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createtime;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;



    private static final long serialVersionUID = 1L;
}