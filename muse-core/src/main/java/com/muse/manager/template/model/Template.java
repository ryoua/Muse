package com.muse.manager.template.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class Template {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, columnDefinition = "bigint comment '用户id'")
    private long uid;

    @Column(nullable = false, columnDefinition = "varchar(255) comment '模板名称'")
    private String name;

    @Column(nullable = false, columnDefinition = "int default 0 comment '状态, 默认0:待审核'")
    private int status;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(columnDefinition = "datetime comment '创建时间'")
    protected Date createTime;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "datetime comment '更新时间'")
    protected Date updateTime;

    @Column(columnDefinition = "bit comment '逻辑删除'")
    protected Boolean valid;
}
