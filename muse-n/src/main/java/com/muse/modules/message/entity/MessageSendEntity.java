package com.muse.modules.message.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 消息发送
 */
@Data
@TableName("message_send")
public class MessageSendEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long id;
    /**
     *
     */
    private String userId;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private Boolean delay;
    /**
     *
     */
    private String delayTime;
    /**
     *
     */
    private Integer contentType;
    /**
     *
     */
    private Boolean contentIsTemplate;
    /**
     *
     */
    private Long contentTid;
    /**
     *
     */
    private Long contentMscId;
    /**
     *
     */
    private Boolean receiverIsTemplate;
    /**
     *
     */
    private Long receiverTid;
    /**
     *
     */
    private Long receiverMsrId;
    /**
     * 创建时间
     */
    private Date createDate;

}
