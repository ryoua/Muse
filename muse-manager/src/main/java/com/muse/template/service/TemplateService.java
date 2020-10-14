package com.muse.template.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Service
public class TemplateService {
    @Autowired
    Gson gson;

//    public void addTemplate(Template template) {
//        switch (template.getType()) {
//            case TemplateType.EMAIL: {
//                addEmailTemplate((EmailTemplate) template);
//                break;
//            }
//        }
//    }
//
//    public void addEmailTemplate(EmailTemplate template) {
//        String body = template.getBody();
//
//    }
}
