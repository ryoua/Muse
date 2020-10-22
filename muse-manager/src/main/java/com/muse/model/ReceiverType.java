package com.muse.model;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/21
 **/
public enum ReceiverType {
    /**
     * 字符串输入
     */
    STRING(1),

    /**
     * 文件
     */
    FILE(2),

    /**
     * SQL
     */
    SQL(3);

    private int type;

    ReceiverType(int type) {
        this.type = type;
    }
}
