 package com.muse.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.muse.entity.SysLogEntity;
import com.muse.utils.PageUtils;

import java.util.Map;


 /**
  * 系统日志
  */
 public interface SysLogService extends IService<SysLogEntity> {

     PageUtils queryPage(Map<String, Object> params);

 }
