package com.muse.modules.template.entity;

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
@TableName("template_email")
public class TemplateEmailEntity implements Serializable {
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
     * 标题
     */
    private String subject;
    /**
     * 抄送
     */
    private String copy;
    /**
     * 内容
     */
    private String content;
    /**
     *
     */
    private Date createDate;

}

