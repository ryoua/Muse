package com.muse.modules.message.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author：ryoua
 * @date：2020/12/10
 **/
@Getter
@Setter
public class MessageContentVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean isTemplate;

    private int type;;

    private Map<String, Object> email;
}
