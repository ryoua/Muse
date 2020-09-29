package com.muse.message.model;

/**
 * 消息类型
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
public enum MessageType {
    /**
     * 短信
     */
    SMS(1),
    /**
     * 邮件
     */
    EMAIL(2),
    /**
     * QQ
     */
    QQ(3),
    /**
     * 微信
     */
    WX(4),
    /**
     * 小程序
     */
    APPLETS(5),
    /**
     * 通知消息
     */
    NOTIFICATE_MSG(6),
    /**
     * IM
     */
    IM_MSG(7);

    private int type;

    MessageType(int type) {
        this.type = type;
    }
}
