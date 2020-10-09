package com.muse.manager.template.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


/**
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
@Data
public class Template {
    /**
     * 模板ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long templateId;

    @Column
    private int templateType;

    /**
     * 消息名称
     */
    @Column(nullable = false, length = 128)
    private String messageName;

    /**
     * 发送周期类型, 1:立即发送, 2:定时发送, 3:周期发送
     */
    @Column(nullable = false)
    private int sendCycleType;
    /**
     * 接受者Id的类型, 1: userid, 2.did ,3: phone
     */
    @Column(nullable = false)
    private int receiverIdType;
    /**
     * 创建者信息
     */
    @Column(length = 64)
    private String creatorName;
    /**
     * 创建者电话
     */
    @Column(length = 32)
    private String creatorPhone;

    /**
     * 消息体, 直接使用一整个JSON保存
     */
    private String messageBody;

    @LastModifiedDate
    private Date updateTime;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createTime;

    @Column(columnDefinition = "tinyint default 1")
    private boolean valid;
}
