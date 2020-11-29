package com.muse.manager.setting.mapper;

import com.muse.manager.setting.model.EmailSetting;
import com.muse.manager.setting.model.EmailSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/27
 **/
@Mapper
public interface EmailSettingMapper {
    long countByExample(EmailSettingExample example);

    int deleteByExample(EmailSettingExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(EmailSetting record);

    int insertOrUpdate(EmailSetting record);

    int insertOrUpdateSelective(EmailSetting record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(EmailSetting record);

    List<EmailSetting> selectByExample(EmailSettingExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    EmailSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmailSetting record, @Param("example") EmailSettingExample example);

    int updateByExample(@Param("record") EmailSetting record, @Param("example") EmailSettingExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(EmailSetting record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(EmailSetting record);

    int updateBatch(List<EmailSetting> list);

    int batchInsert(@Param("list") List<EmailSetting> list);
}