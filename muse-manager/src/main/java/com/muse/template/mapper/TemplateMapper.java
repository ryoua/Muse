package com.muse.template.mapper;

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
