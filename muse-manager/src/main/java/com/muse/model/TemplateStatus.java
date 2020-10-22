package com.muse.model;


/**
 * 模板的状态
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
public enum  TemplateStatus {
    /**
     * 等待审核
     */
    WAITING_EXAMINE(1),
    /**
     * 审核通过
     */
    PASS_EXAMINE(2),
    /**
     * 审核未通过
     */
    NO_PASS_EXAMINE(3),
    /**
     * 已被删除
     */
    DELETE(4);

    private int status;

    TemplateStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
