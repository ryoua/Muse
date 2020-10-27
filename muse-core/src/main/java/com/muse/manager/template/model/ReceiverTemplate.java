package com.muse.manager.template.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
** @Author: RyouA
** @Date: 2020/10/27
**/
@ApiModel(value="com-muse-manager-template-model-ReceiverTemplate")
@Data
public class ReceiverTemplate implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createtime;

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
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long uid;

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
    * 文件形式的用户, 只保存url
    */
    @ApiModelProperty(value="文件形式的用户, 只保存url")
    private String fileurl;

    /**
    * 用户id类型
    */
    @ApiModelProperty(value="用户id类型")
    private Integer receivertype;

    /**
    * 模板类型
    */
    @ApiModelProperty(value="模板类型")
    private Integer templatetype;

    /**
    * 字符串形式的用户
    */
    @ApiModelProperty(value="字符串形式的用户")
    private String receivers;

    /**
    * sql格式的用户
    */
    @ApiModelProperty(value="sql格式的用户")
    private String sqlstr;

    private static final long serialVersionUID = 1L;
}