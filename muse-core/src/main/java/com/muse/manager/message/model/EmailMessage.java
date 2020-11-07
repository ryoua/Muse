package com.muse.manager.message.model;

import lombok.Getter;
import lombok.Setter;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/4
 **/
@Getter
@Setter
public class EmailMessage {
    private String title;
    private String[] copy;
    private String content;
    private String[] attachment;
    private int type;
}
