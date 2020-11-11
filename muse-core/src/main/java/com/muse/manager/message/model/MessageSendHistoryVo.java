package com.muse.manager.message.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/8
 **/
@Getter
@Setter
public class MessageSendHistoryVo {
    private Long id;

    @SerializedName("messageName")
    @ApiModelProperty(value = "消息名称")
    private String name;

    @ApiModelProperty(value = "发送类型")
    private int type;

    @ApiModelProperty(value = "消息类型")
    private int messageType;

    @ApiModelProperty(value = "接收人群类型")
    private int receiverType;

    @ApiModelProperty(value = "执行步骤")
    private int step;

    @ApiModelProperty(value = "总发送数量")
    private long receiverSize;

    @ApiModelProperty(value = "成功发送数量")
    private long receiverSuccess;

    @ApiModelProperty(value = "失败发送数量")
    private long receiverFail;

    @ApiModelProperty(value = "创建时间")
    private String createTime;
}
