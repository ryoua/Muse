package com.muse.dispatcher.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/14
 **/
@Getter
@Setter
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
