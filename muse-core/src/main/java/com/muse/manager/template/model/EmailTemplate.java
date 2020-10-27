package com.muse.manager.template.model;

import lombok.Getter;
import lombok.Setter;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Getter
@Setter
public class EmailTemplate extends Template {
    private String title;

    private String copy;

    private String attachmentUrl;

    private String content;
}
