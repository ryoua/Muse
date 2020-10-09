package com.muse.message.transfer.dispatcher;

import com.muse.manager.template.model.Template;
import com.muse.manager.template.service.Impl.TemplateServiceImpl;
import com.muse.manager.template.status.TemplateType;
import com.muse.message.transfer.model.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/9
 **/
@Component
public class MessageDisPatcher {
    @Autowired
    TemplateServiceImpl templateService;

    public void dispatch(SendParam sendParam) {
        Template template = templateService.queryTemplateById(sendParam.getTemplateId());
        int templateType = template.getTemplateType();
        if (templateType == TemplateType.BUSINESS_TEMPLATE) {

        } else if (templateType == TemplateType.OPERATE_TEMPLATE) {

        }
    }


}
