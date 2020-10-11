package com.muse.dispatcher.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 消息参数
 * * @Author: RyouA
 * * @Date: 2020/9/26
 **/
@Data
public class MsgParam {

    /**
     * 接受者
     */
    private List<String> receiver;

    /**
     * 自定义参数 (文案)
     */
    private Map<String, Object> variables;
}
