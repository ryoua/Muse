package com.muse.dispatch.event;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
public class MessageData {



    private String receiver;

    private String message;

    public MessageData() {
    }

    public MessageData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
