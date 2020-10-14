package com.muse.dispatcher.api.controller;

import com.muse.dispatcher.api.model.SendParam;
import com.muse.dispatcher.route.StandardUnifiedRouter;
import com.muse.model.Result;
import com.muse.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * * @Author: RyouA
 * * @Date: 2020/10/14
 **/
@RequestMapping("/dispatcher")
@RestController
public class ApiController {
    @Autowired
    StandardUnifiedRouter router;

    @PostMapping("/send")
    public Result<?> SendMessage(@RequestBody SendParam sendParam) {
        int result = router.routeSendParam(sendParam);
        return ControllerUtil.checkResult(result);
    }
}
