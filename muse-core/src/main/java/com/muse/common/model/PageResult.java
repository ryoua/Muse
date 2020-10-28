package com.muse.common.model;

import com.github.pagehelper.PageInfo;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/27
 **/
public class PageResult<T> {

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

    int pageSize;
    int pageNo;
    long totalCount;
    int totalPage;

    public PageResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public PageResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        PageInfo pageInfo = (PageInfo) data;
        this.data = (T) pageInfo.getList();
        this.pageNo = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalCount = pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
    }


    public PageResult(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public PageResult(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        PageInfo pageInfo = (PageInfo) data;
        this.data = (T) pageInfo.getList();
        this.pageNo = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalCount = pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public PageResult(String message) {
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
