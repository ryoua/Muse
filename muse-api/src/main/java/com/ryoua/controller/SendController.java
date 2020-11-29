package com.ryoua.controller;

import com.ryoua.email.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/29
 **/
@RestController
public class SendController {
    @Autowired
    private IMailService iMailService;

}
