package com.muse.manager.template.service.Impl;

import com.muse.manager.template.dao.TemplateRepository;
import com.muse.manager.template.model.BusinessTemplate;
import com.muse.manager.template.model.OperateTemplate;
import com.muse.manager.template.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import com.muse.manager.template.service.TemplateService;
import org.springframework.stereotype.Service;
import com.muse.manager.template.status.DbOperate;

/**
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public Template queryTemplateById(long id) {
        return (Template) templateRepository.findById(id).get();
    }

    @Override
    public int addBusinessTemplate(BusinessTemplate businessTemplate) {
        try {
            templateRepository.save(businessTemplate);
            return DbOperate.SUCCESS;
        } catch (Exception e) {
            return DbOperate.FAILED;
        }
    }

    @Override
    public int addOperateTemplate(OperateTemplate operateTemplate) {
        try {
            templateRepository.save(operateTemplate);
            return DbOperate.SUCCESS;
        } catch (Exception e) {
            return DbOperate.FAILED;
        }
    }

    @Override
    public int updateBusinessTemplate(BusinessTemplate businessTemplate) {
        try {
            templateRepository.save(businessTemplate);
            return DbOperate.SUCCESS;
        } catch (Exception e) {
            return DbOperate.FAILED;
        }
    }

    @Override
    public int updateOperateTemplate(OperateTemplate operateTemplate) {
        try {
            templateRepository.save(operateTemplate);
            return DbOperate.SUCCESS;
        } catch (Exception e) {
            return DbOperate.FAILED;
        }
    }

    @Override
    public int deleteOperateTemplate(long id) {
        try {
            templateRepository.deleteById(id);
            return DbOperate.SUCCESS;
        } catch (Exception e) {
            return DbOperate.FAILED;
        }
    }

    @Override
    public int deleteBusinessTemplate(long id) {
        try {
            templateRepository.deleteById(id);
            return DbOperate.SUCCESS;
        } catch (Exception e) {
            return DbOperate.FAILED;
        }
    }

    @Override
    public BusinessTemplate queryBusinessTemplate(long id) {
        return (BusinessTemplate) templateRepository.findById(id).orElseGet(null);
    }

    @Override
    public OperateTemplate queryOperateTemplate(long id) {
        return (OperateTemplate) templateRepository.findById(id).orElseGet(null);
    }

}
