package com.muse.message.controller;

import java.util.Arrays;
import java.util.Map;

import com.muse.message.entity.MessageSendEntity;
import com.muse.message.service.MessageSendService;
import com.muse.utils.PageUtils;
import com.muse.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 消息发送
 *
 */
@RestController
@RequestMapping("/message/send")
public class MessageSendController {
    @Autowired
    private MessageSendService messageSendService;

    @RequestMapping("/list/name")
    public Result listName() {
        return Result.ok().put("data", messageSendService.queryNames());
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = messageSendService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){
        MessageSendEntity messageSend = messageSendService.getById(id);

        return Result.ok().put("messageSend", messageSend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody MessageSendEntity messageSend){
        messageSendService.save(messageSend);

        return R.ok();
    }

    @RequestMapping("/")
    public Result sendMessage( ) {
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody MessageSendEntity messageSend){
        messageSendService.updateById(messageSend);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] ids){
        messageSendService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
