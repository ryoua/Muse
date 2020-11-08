package com.muse.manager.statistics.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
** @Author: RyouA
** @Date: 2020/11/8
**/
@ApiModel(value="com-muse-manager-statistics-model-MessageSendStatistics")
@Getter
@Setter
@ToString
public class MessageSendStatistics implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long msid;

    @ApiModelProperty(value="")
    private Long receiverSize;

    @ApiModelProperty(value="")
    private Long receiverSuccess;

    @ApiModelProperty(value="")
    private Long receiverFail;

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