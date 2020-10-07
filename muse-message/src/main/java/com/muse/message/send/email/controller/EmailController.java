package com.muse.message.send.email.controller;

import com.muse.common.model.Result;
import com.muse.message.send.email.service.IMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/7
 **/
@RestController
public class EmailController {
    @Autowired
    private IMailServiceImpl mailService;

    @GetMapping("/")
    public Result index(){
        try {
            mailService.sendSimpleMail("1794970183@qq.com","SpringBoot Email","这是一封普通的SpringBoot测试邮件");
        }catch (Exception ex){
            ex.printStackTrace();
            return new Result<>(-1,"邮件发送失败!!");
        }
        return Result.SUCCESS();
    }
}
