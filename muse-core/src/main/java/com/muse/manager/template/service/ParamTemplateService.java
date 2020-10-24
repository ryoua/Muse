package com.muse.manager.template.service;

import com.muse.manager.template.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@Service
public class ParamTemplateService {
    @Autowired
    private EmailTemplateRepository emailTemplateRepository;
}
