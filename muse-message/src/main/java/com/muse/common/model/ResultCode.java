package com.muse.common.model;

import lombok.Data;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/6
 **/
public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(200, "操作成功！"),

    /* 错误状态码 */
    FAIL(500, "操作失败！");

    int code;
    String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
