package com.muse.message.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
@Data
public class Template {
    /**
     * 模板ID
     */
    @SerializedName("template_id")
    private long templateId;
    /**
     * 消息名称
     */
    @SerializedName("message_name")
    private String messageName;
    /**
     * 发送周期类型, 1:立即发送, 2:定时发送, 3:周期发送
     */
    @SerializedName("send_cycle_type")
    private int sendCycleType;
    /**
     * 接受者Id的类型, 1: userid, 2: phone
     */
    @SerializedName("receiver_id_type")
    private int receiverIdType;
    /**
     * 创建者信息
     */
    @SerializedName("creator_name")
    private String creatorName;
    /**
     * 创建者电话
     */
    @SerializedName("creator_phone")
    private String creatorPhone;

    /**
     * 消息体, 直接使用一整个JSON保存
     */
    @SerializedName("message_body")
    private String messageBody;
}
