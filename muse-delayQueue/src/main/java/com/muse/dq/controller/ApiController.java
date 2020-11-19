package com.muse.dq.controller;

import com.muse.dq.model.Job;
import com.muse.dq.model.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/19
 **/
@RestController
public class ApiController {
    @PostMapping("/job")
    public Result addJob(@RequestBody Job job) {
        return Result.SUCCESS();
    }
}
