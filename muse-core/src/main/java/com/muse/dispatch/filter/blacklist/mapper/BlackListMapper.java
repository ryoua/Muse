package com.muse.dispatch.filter.blacklist.mapper;

import com.muse.dispatch.filter.blacklist.model.BlackList;
import com.muse.dispatch.filter.blacklist.model.BlackListExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
** @Author: RyouA
** @Date: 2020/11/14
**/
@Mapper
public interface BlackListMapper {
    long countByExample(BlackListExample example);

    int deleteByExample(BlackListExample example);

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
    int insert(BlackList record);

    int insertOrUpdate(BlackList record);

    int insertOrUpdateSelective(BlackList record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(BlackList record);

    List<BlackList> selectByExample(BlackListExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    BlackList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlackList record, @Param("example") BlackListExample example);

    int updateByExample(@Param("record") BlackList record, @Param("example") BlackListExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BlackList record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BlackList record);

    int updateBatch(List<BlackList> list);

    int batchInsert(@Param("list") List<BlackList> list);
}