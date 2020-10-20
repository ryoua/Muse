package com.muse.model;

import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/20
 **/
@Getter
@Setter
public class MessageSend extends BaseModel {
    private Long id;
    private Long uid;

    private String messageName;
    private Integer messageType;

    private Long paramTemplateId;
    private String paramStr;

    private Long receiverTemplateId;
    private Integer receiverType;
    private String receivers;
    private String receiverSql;
    private String receiverFileUrl;
}
