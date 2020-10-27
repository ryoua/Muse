package com.muse.common.model;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/27
 **/
public class PageResult<T> {

    /**
     * 操作代码
     */
    int code;

    private int pageNo;

    private int pageSize;

    private long totalCount;

    private int totalPage;

    /**
     * 提示信息
     */
    String message;

    /**
     * 结果数据
     */
    T data;

    public PageResult(int code, String message, int pageNo, int pageSize, long totalCount) {
        this.code = code;
        this.message = message;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (int) (totalCount / pageSize) + 1;
    }

    public PageResult(int code, String message, T data, int pageNo, int pageSize, long totalCount) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (int) (totalCount / pageSize) + 1;
    }


    public PageResult(ResultCode resultCode, int pageNo, int pageSize, long totalCount) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (int) (totalCount / pageSize) + 1;
    }

    public PageResult(ResultCode resultCode, T data, int pageNo, int pageSize, long totalCount) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        this.totalPage = (int) (totalCount / pageSize) + 1;
    }

    public PageResult(String message, int pageNo, int pageSize, long totalCount) {
        this.message = message;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        this.totalPage = (int) (totalCount / pageSize) + 1;
    }

    public static com.muse.common.model.Result<ResultCode> SUCCESS() {
        return new com.muse.common.model.Result<>(ResultCode.SUCCESS);
    }

    public static <T> com.muse.common.model.Result<?> SUCCESS(T data) {
        return new com.muse.common.model.Result<>(ResultCode.SUCCESS, data);
    }

    public static com.muse.common.model.Result<ResultCode> FAIL() {
        return new com.muse.common.model.Result<>(ResultCode.FAIL);
    }

    public static com.muse.common.model.Result<?> FAIL(String message) {
        return new com.muse.common.model.Result<>(message);
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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
