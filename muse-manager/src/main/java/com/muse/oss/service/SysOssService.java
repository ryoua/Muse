 package com.muse.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muse.oss.entity.SysOssEntity;
import com.muse.utils.PageUtils;

import java.util.Map;

 /**
  * 文件上传
  */
 public interface SysOssService extends IService<SysOssEntity> {

     PageUtils queryPage(Map<String, Object> params);
 }
