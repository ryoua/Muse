 package com.muse.oss.controller;

import com.google.gson.Gson;
import com.muse.exception.MuseException;
import com.muse.oss.cloud.CloudStorageConfig;
import com.muse.oss.cloud.OSSFactory;
import com.muse.oss.entity.SysOssEntity;
import com.muse.oss.service.SysOssService;
import com.muse.utils.Constant;
import com.muse.utils.PageUtils;
import com.muse.utils.Result;
import com.muse.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

 /**
  * 文件上传
  */
 @RestController
 @RequestMapping("sys/oss")
 public class SysOssController {
     @Autowired
     private SysOssService sysOssService;
     @Autowired
     private com.muse.modules.sys.service.SysConfigService sysConfigService;

     private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;

     /**
      * 列表
      */
     @GetMapping("/list")
     @RequiresPermissions("sys:oss:all")
     public Result list(@RequestParam Map<String, Object> params){
         PageUtils page = sysOssService.queryPage(params);

         return Result.ok().put("page", page);
     }


     /**
      * 云存储配置信息
      */
     @GetMapping("/config")
     @RequiresPermissions("sys:oss:all")
     public Result config(){
         CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

         return Result.ok().put("config", config);
     }


     /**
      * 保存云存储配置信息
      */
     @PostMapping("/saveConfig")
     @RequiresPermissions("sys:oss:all")
     public Result saveConfig(@RequestBody CloudStorageConfig config){
         //校验类型
         ValidatorUtils.validateEntity(config);

         if(config.getType() == Constant.CloudService.QINIU.getValue()){
             //校验七牛数据
             ValidatorUtils.validateEntity(config, QiniuGroup.class);
         }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
             //校验阿里云数据
             ValidatorUtils.validateEntity(config, AliyunGroup.class);
         }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
             //校验腾讯云数据
             ValidatorUtils.validateEntity(config, QcloudGroup.class);
         }

         sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));

         return Result.ok();
     }


     /**
      * 上传文件
      */
     @PostMapping("/upload")
     @RequiresPermissions("sys:oss:all")
     public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
         if (file.isEmpty()) {
             throw new MuseException("上传文件不能为空");
         }

         //上传文件
         String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
         String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);

         //保存文件信息
         SysOssEntity ossEntity = new SysOssEntity();
         ossEntity.setUrl(url);
         ossEntity.setCreateDate(new Date());
         sysOssService.save(ossEntity);

         return Result.ok().put("url", url);
     }


     /**
      * 删除
      */
     @PostMapping("/delete")
     @RequiresPermissions("sys:oss:all")
     public Result delete(@RequestBody Long[] ids){
         sysOssService.removeByIds(Arrays.asList(ids));

         return Result.ok();
     }

 }
