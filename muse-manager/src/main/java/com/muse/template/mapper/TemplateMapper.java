package com.muse.template.mapper;

import com.muse.model.Template;
import org.mapstruct.Mapper;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Mapper
public interface TemplateMapper {
    void addTemplate(Template template);
}
