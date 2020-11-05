package com.muse.manager.template.mapper;

import com.muse.manager.template.model.MessageTemplate;
import com.muse.manager.template.model.MessageTemplateExample;
import java.util.List;

import com.muse.manager.template.model.TemplateShort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/5
**/
@Mapper
public interface MessageTemplateMapper {
    long countByExample(MessageTemplateExample example);

    int deleteByExample(MessageTemplateExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MessageTemplate record);

    int insertOrUpdate(MessageTemplate record);

    int insertOrUpdateSelective(MessageTemplate record);

    int insertOrUpdateWithBLOBs(MessageTemplate record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MessageTemplate record);

    List<MessageTemplate> selectByExampleWithBLOBs(MessageTemplateExample example);

    List<MessageTemplate> selectByExample(MessageTemplateExample example);

    List<TemplateShort> selectTemplateShort(long uid);

    List<TemplateShort> selectMessageTemplateNameLike(MessageTemplate template);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MessageTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageTemplate record, @Param("example") MessageTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageTemplate record, @Param("example") MessageTemplateExample example);

    int updateByExample(@Param("record") MessageTemplate record, @Param("example") MessageTemplateExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MessageTemplate record);

    int updateByPrimaryKeyWithBLOBs(MessageTemplate record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MessageTemplate record);

    int updateBatch(List<MessageTemplate> list);

    int batchInsert(@Param("list") List<MessageTemplate> list);
}