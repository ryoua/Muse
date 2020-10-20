package com.muse.model;

import lombok.Getter;
import lombok.Setter;


/**
 * 邮箱模板参数, 不存入数据库, 序列化json存入模板通用表
 * * @Author: RyouA
 * * @Date: 2020/10/19
 **/
@Getter
@Setter
public class EmailTemplate {
    private String title;
    private String copy;
    private String content;
    private String attachmentUrl;
}
