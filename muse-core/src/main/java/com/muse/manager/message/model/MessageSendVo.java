package com.muse.manager.message.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/8
 **/
@Getter
@Setter
public class MessageSendVo {
    private String name;
    private Integer type;

    private Map<String, Object> message;
    private Map<String, Object> receiver;
}
