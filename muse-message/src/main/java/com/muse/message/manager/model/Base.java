package com.muse.message.manager.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;

@Data
public class Base {
    @LastModifiedDate
    private Date updateTime;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createTime;

    @Column(columnDefinition = "tinyint default 1")
    private boolean valid;
}
