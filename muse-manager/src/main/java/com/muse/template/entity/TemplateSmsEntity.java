package com.muse.template.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Data
@TableName("template_sms")
public class TemplateSmsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long userId;
    /**
     * 模板名称
     */
    private String name;
    /**
     * 服务商
     */
    private Integer cp;
    /**
     * 模板id

     */
    private String templateId;
    /**
     *
     */
    private Date createDate;

}

