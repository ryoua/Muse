package com.muse.manager.template.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_receiver_template")
public class ReceiverTemplate extends Template {

    @Column(nullable = false, columnDefinition = "int comment '模板类型'")
    private int templateType;

    @Column(nullable = false, columnDefinition = "int comment '用户id类型'")
    private int receiverType;

    @Lob
    @Column(columnDefinition = "text comment '字符串形式的用户'")
    private String receivers;

    @SerializedName("sql")
    @Lob
    @Column(columnDefinition = "text comment 'sql格式的用户'")
    private String sqlStr;

    @Column(columnDefinition = "varchar(255) comment '文件形式的用户, 只保存url'")
    private String fileUrl;
}
