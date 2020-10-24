package com.muse.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseModel {
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
