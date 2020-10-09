package com.muse.manager.template.dao;


import com.muse.manager.template.model.Template;
import org.springframework.data.repository.CrudRepository;

public interface TemplateRepository<T extends Template> extends CrudRepository<T, Long> {

}
