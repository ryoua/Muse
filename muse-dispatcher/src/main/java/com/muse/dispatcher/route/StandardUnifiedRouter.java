package com.muse.dispatcher.route;

import com.google.gson.Gson;
import com.muse.dispatcher.api.model.SendParam;
import com.muse.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/14
 **/
@Component
public class StandardUnifiedRouter {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    Gson gson;

    public int routeSendParam(SendParam sendParam) {
        long templateId = sendParam.getTemplateId();
        String templateStr = redisUtil.get(String.valueOf(templateId));
        Template template = gson.fromJson(templateStr, Template.class);
        return 1;
    }
}
