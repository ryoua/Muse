package com.muse.modules.message.controller;

import java.util.Arrays;
import java.util.Map;

import com.muse.common.utils.R;
import com.muse.modules.message.entity.MessageSendEntity;
import com.muse.modules.message.service.MessageSendService;
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
    public R listName() {
        return R.ok().put("data", messageSendService.queryNames());
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = messageSendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MessageSendEntity messageSend = messageSendService.getById(id);

        return R.ok().put("messageSend", messageSend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MessageSendEntity messageSend){
        messageSendService.save(messageSend);

        return R.ok();
    }

    @RequestMapping("/")
    public R sendMessage( ) {
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MessageSendEntity messageSend){
        messageSendService.updateById(messageSend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        messageSendService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
