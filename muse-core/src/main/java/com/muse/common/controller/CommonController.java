package com.muse.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/26
 **/
@Controller
public class CommonController {
    @GetMapping(value="/**")
    public String index(){
        return "index";
    }
}
