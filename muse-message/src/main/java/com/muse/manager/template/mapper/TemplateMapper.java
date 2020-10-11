package com.muse.manager.template.mapper;

import com.muse.manager.template.model.Template;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Mapper
public interface TemplateMapper {
    void addTemplate(Template template);
}
