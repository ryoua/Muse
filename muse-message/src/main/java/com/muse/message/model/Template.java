package com.muse.message.model;

import com.google.gson.annotations.SerializedName;
import com.muse.message.status.TemplateStatus;
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
    private long templateId;

    /**
     * 模板状态
     */
    private TemplateStatus templateStatus;

    /**
     * 消息名称
     */
    private String messageName;
    /**
     * 发送周期类型, 1:立即发送, 2:定时发送, 3:周期发送
     */
    private int sendCycleType;
    /**
     * 接受者Id的类型, 1: userid, 2: phone
     */
    private int receiverIdType;
    /**
     * 创建者信息
     */
    private String creatorName;
    /**
     * 创建者电话
     */
    private String creatorPhone;

    /**
     * 消息体, 直接使用一整个JSON保存
     */
    private String messageBody;
}
