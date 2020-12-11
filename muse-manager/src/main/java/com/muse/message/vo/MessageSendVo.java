package com.muse.message.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author：ryoua
 * @date：2020/12/10
 **/
@Getter
@Setter
public class MessageSendVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer delayTime;

    private Boolean delay;

    private MessageContentVo messageContentVo;

    private MessageReceiverVo receiverVo;
}
