package com.muse.manager.template.mapper;

import com.muse.manager.template.model.ReceiverTemplate;
import com.muse.manager.template.model.ReceiverTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/10/28
**/
@Mapper
public interface ReceiverTemplateMapper {
    long countByExample(ReceiverTemplateExample example);

    int deleteByExample(ReceiverTemplateExample example);

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
    int insert(ReceiverTemplate record);

    int insertOrUpdate(ReceiverTemplate record);

    int insertOrUpdateSelective(ReceiverTemplate record);

    int insertOrUpdateWithBLOBs(ReceiverTemplate record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ReceiverTemplate record);

    List<ReceiverTemplate> selectByExampleWithBLOBs(ReceiverTemplateExample example);

    List<ReceiverTemplate> selectByExample(ReceiverTemplateExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ReceiverTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiverTemplate record, @Param("example") ReceiverTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") ReceiverTemplate record, @Param("example") ReceiverTemplateExample example);

    int updateByExample(@Param("record") ReceiverTemplate record, @Param("example") ReceiverTemplateExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ReceiverTemplate record);

    int updateByPrimaryKeyWithBLOBs(ReceiverTemplate record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ReceiverTemplate record);

    int updateBatch(List<ReceiverTemplate> list);

    int batchInsert(@Param("list") List<ReceiverTemplate> list);
}