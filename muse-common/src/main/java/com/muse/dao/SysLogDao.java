 package com.muse.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muse.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

 /**
  * 系统日志
  */
 @Mapper
 public interface SysLogDao extends BaseMapper<SysLogEntity> {

 }
