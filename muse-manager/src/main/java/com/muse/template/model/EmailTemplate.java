package com.muse.template.model;

import lombok.Data;

import java.io.File;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Data
public class EmailTemplate extends Template {
    private String title;
    private String copy;
    private File attachment;
    private String content;

    @Override
    public String toString() {
        return "{" + "\"title\":\"" +
                title + '\"' +
                ",\"copy\":\"" +
                copy + '\"' +
                ",\"attachment\":" +
                attachment +
                ",\"content\":\"" +
                content + '\"' +
                '}';
    }
}
