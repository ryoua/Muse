package com.muse.manager.setting.mapper;

import com.muse.manager.setting.model.DatabaseSetting;
import com.muse.manager.setting.model.DatabaseSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/21
**/
@Mapper
public interface DatabaseSettingMapper {
    long countByExample(DatabaseSettingExample example);

    int deleteByExample(DatabaseSettingExample example);

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
    int insert(DatabaseSetting record);

    int insertOrUpdate(DatabaseSetting record);

    int insertOrUpdateSelective(DatabaseSetting record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(DatabaseSetting record);

    List<DatabaseSetting> selectByExample(DatabaseSettingExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    DatabaseSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DatabaseSetting record, @Param("example") DatabaseSettingExample example);

    int updateByExample(@Param("record") DatabaseSetting record, @Param("example") DatabaseSettingExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(DatabaseSetting record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(DatabaseSetting record);

    int updateBatch(List<DatabaseSetting> list);

    int batchInsert(@Param("list") List<DatabaseSetting> list);
}