package com.muse.message.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/18
 **/
@Getter
@Setter
public class MessageSendVo {
    private String messageType;
    private String messageName;
    private String receiverType;
    private String receivers;
    private String receiverTemplateId;
    private String sql;
    private String param;
    private String paramTemplateId;
}
