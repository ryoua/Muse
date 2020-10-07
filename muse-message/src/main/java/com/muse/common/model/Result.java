package com.muse.common.model;

import lombok.Data;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/6
 **/
public class Result<T> {

    /**
     * 操作代码
     */
    int code;

    /**
     * 提示信息
     */
    String message;

    /**
     * 结果数据
     */
    T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public Result(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Result(String message) {
        this.message = message;
    }

    public static Result<ResultCode> SUCCESS() {
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<?> SUCCESS(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static Result<ResultCode> FAIL() {
        return new Result<>(ResultCode.FAIL);
    }

    public static Result<?> FAIL(String message) {
        return new Result<>(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

