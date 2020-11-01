package com.muse.manager.template.mapper;

import com.muse.manager.template.model.ParamTemplate;
import com.muse.manager.template.model.ParamTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/1
**/
@Mapper
public interface ParamTemplateMapper {
    long countByExample(ParamTemplateExample example);

    int deleteByExample(ParamTemplateExample example);

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
    int insert(ParamTemplate record);

    int insertOrUpdate(ParamTemplate record);

    int insertOrUpdateSelective(ParamTemplate record);

    int insertOrUpdateWithBLOBs(ParamTemplate record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ParamTemplate record);

    List<ParamTemplate> selectByExampleWithBLOBs(ParamTemplateExample example);

    List<ParamTemplate> selectByExample(ParamTemplateExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ParamTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParamTemplate record, @Param("example") ParamTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") ParamTemplate record, @Param("example") ParamTemplateExample example);

    int updateByExample(@Param("record") ParamTemplate record, @Param("example") ParamTemplateExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ParamTemplate record);

    int updateByPrimaryKeyWithBLOBs(ParamTemplate record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ParamTemplate record);

    int updateBatch(List<ParamTemplate> list);

    int batchInsert(@Param("list") List<ParamTemplate> list);
}