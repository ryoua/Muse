package com.muse.message.send.service;

import model.BusinessTemplate;
import model.OperateTemplate;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
public interface TemplateService {
    /**
     * 新增业务模板
     * @param businessTemplate
     * @return
     */
    int addBusinessTemplate(BusinessTemplate businessTemplate);

    /**
     * 新增营销模板
     * @param operateTemplate
     * @return
     */
    int addOperateTemplate(OperateTemplate operateTemplate);
}
