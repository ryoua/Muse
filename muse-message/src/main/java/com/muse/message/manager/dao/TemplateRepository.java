package com.muse.message.manager.dao;


import com.muse.message.manager.model.Template;
import org.springframework.data.repository.CrudRepository;

public interface TemplateRepository<T extends Template> extends CrudRepository<T, Long> {

}
