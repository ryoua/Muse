package com.muse.manager.template.service;

import com.muse.manager.template.model.BusinessTemplate;
import com.muse.manager.template.model.OperateTemplate;

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
     * 新增技术模板
     * @param operateTemplate
     * @return
     */
    int addOperateTemplate(OperateTemplate operateTemplate);

    /**
     * 修改业务模板
     * @param businessTemplate
     * @return
     */
    int updateBusinessTemplate(BusinessTemplate businessTemplate);

    /**
     * 修改技术模板
     * @param operateTemplate
     * @return
     */
    int updateOperateTemplate(OperateTemplate operateTemplate);

    /**
     * 删除技术模板
     * @param id
     * @return
     */
    int deleteOperateTemplate(long id);

    /**
     * 删除业务模板
     * @param id
     * @return
     */
    int deleteBusinessTemplate(long id);

    /**
     * 获取业务模板
     * @param id
     * @return
     */
    BusinessTemplate queryBusinessTemplate(long id);

    /**
     * 获取技术模板
     * @param id
     * @return
     */
    OperateTemplate queryOperateTemplate(long id);
}
