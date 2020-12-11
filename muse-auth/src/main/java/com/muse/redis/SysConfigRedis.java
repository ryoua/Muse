 package com.muse.redis;


import com.google.gson.Gson;
import com.muse.modules.sys.entity.SysConfigEntity;
import com.muse.utils.RedisKeys;
import com.muse.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 /**
  * 系统配置Redis
  */
 @Component
 public class SysConfigRedis {
     @Autowired
     private RedisUtil redisUtils;
     @Autowired
     Gson gson;

     public void saveOrUpdate(SysConfigEntity config) {
         if(config == null){
             return ;
         }
         String key = RedisKeys.getSysConfigKey(config.getParamKey());
         redisUtils.set(key, gson.toJson(config));
     }

     public void delete(String configKey) {
         String key = RedisKeys.getSysConfigKey(configKey);
         redisUtils.delete(key);
     }

     public SysConfigEntity get(String configKey){
         String key = RedisKeys.getSysConfigKey(configKey);
         return gson.fromJson(redisUtils.get(key), SysConfigEntity.class);
     }
 }
