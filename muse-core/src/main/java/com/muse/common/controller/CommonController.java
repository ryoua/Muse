package com.muse.common.controller;

import com.muse.common.exception.MuseException;
import com.muse.common.util.AliyunOSSUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
@RestController
public class CommonController {
    private static final String UTIL_TAG = "工具类";


    @PostMapping("/upload")
    @ApiOperation(value = "上传文件", tags = UTIL_TAG, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "file"),
    })
    public String upload(@RequestParam MultipartFile file) {
         return AliyunOSSUtil.upLoad(file);
    }
}
