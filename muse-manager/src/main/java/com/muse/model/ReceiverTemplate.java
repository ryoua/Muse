package com.muse.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 接收人模板参数, 不存入数据库, 序列化json存入模板通用表
 * * @Author: RyouA
 * * @Date: 2020/10/19
 **/
@Getter
@Setter
public class ReceiverTemplate {
    private String type;
    private String receivers;
    private String fileUrl;
    private String sql;
}
