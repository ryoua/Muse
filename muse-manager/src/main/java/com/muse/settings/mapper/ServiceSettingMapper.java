package com.muse.settings.mapper;

import com.muse.settings.model.ServiceSetting;
import com.muse.settings.model.ServiceSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/12/2
**/
@Mapper
public interface ServiceSettingMapper {
    long countByExample(ServiceSettingExample example);

    int deleteByExample(ServiceSettingExample example);

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
    int insert(ServiceSetting record);

    int insertOrUpdate(ServiceSetting record);

    int insertOrUpdateSelective(ServiceSetting record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ServiceSetting record);

    List<ServiceSetting> selectByExample(ServiceSettingExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ServiceSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServiceSetting record, @Param("example") ServiceSettingExample example);

    int updateByExample(@Param("record") ServiceSetting record, @Param("example") ServiceSettingExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ServiceSetting record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ServiceSetting record);

    int updateBatch(List<ServiceSetting> list);

    int batchInsert(@Param("list") List<ServiceSetting> list);
}