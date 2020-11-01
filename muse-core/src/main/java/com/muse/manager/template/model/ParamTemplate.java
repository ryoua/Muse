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
** @Date: 2020/11/1
**/
@ApiModel(value="com-muse-manager-template-model-ParamTemplate")
@Getter
@Setter
@ToString
public class ParamTemplate implements Serializable {
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
    * 模板名称
    */
    @ApiModelProperty(value="模板名称")
    private String name;

    /**
    * 模板类型
    */
    @ApiModelProperty(value="模板类型")
    private Integer templateType;

    /**
    * 状态, 0为待审核
    */
    @ApiModelProperty(value="状态, 0为待审核")
    private Integer status;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    @ApiModelProperty(value="")
    private Boolean valid;

    @ApiModelProperty(value="")
    private String remark;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String content;

    private static final long serialVersionUID = 1L;
}