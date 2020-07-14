package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IAutoReplyBiz;
import com.igeekhome.ccsv2.entity.AutoReply;
import com.igeekhome.ccsv2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/AutoReply")
public class AutoReplyController {
    @Autowired
    private IAutoReplyBiz autoReplyBiz;

    //某一客服登陆打开此页面就会显示，之前的自动回复设置情况
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Result showSetting(int customerServiceId){
        AutoReply AR = autoReplyBiz.showSetting(customerServiceId);
        return Result.ok(AR);
    }


    //更新某一客服‘欢迎消息’，包括开启状态、内容
    @RequestMapping(value = "/saveWelcome", method = RequestMethod.POST)
    @ResponseBody
    public Result saveWelcome(AutoReply autoReply){
        int a = autoReplyBiz.saveWelcome(autoReply);
        return Result.ok(a);
    }
    //更新某一客服的‘顾客无响应时消息’，包括开启状态、内容和发送时限
    @RequestMapping(value = "/saveCSNResponse", method = RequestMethod.POST)
    @ResponseBody
    public Result saveCSNResponse(AutoReply autoReply){
        int a = autoReplyBiz.saveCSNResponse(autoReply);
        return Result.ok(a);
    }
    //更新某一客服的‘对话结束时消息’，包括开启状态、内容和发送时限
    @RequestMapping(value = "/saveCNResponse", method = RequestMethod.POST)
    @ResponseBody
    public Result saveCNResponse(AutoReply autoReply){
        int a = autoReplyBiz.saveCNResponse(autoReply);
        return Result.ok(a);
    }
    //更新某一客服的‘客服无应答时消息’，包括开启状态、客服手动结束时内容和系统自动关闭时内容
    @RequestMapping(value = "/saveEnd", method = RequestMethod.POST)
    @ResponseBody
    public Result saveEnd(AutoReply autoReply){
        int a = autoReplyBiz.saveEnd(autoReply);
        return Result.ok(a);
    }

}
