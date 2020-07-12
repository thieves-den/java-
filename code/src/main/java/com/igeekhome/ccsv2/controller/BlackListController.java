package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IBlackListBiz;
import com.igeekhome.ccsv2.entity.BlackList;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/black")
@CrossOrigin
public class BlackListController {

    @Autowired
    private IBlackListBiz blackListBiz;
    /**
     * 解除客户黑名单的功能
     */
    @RequestMapping(value = {"/delete"},method = RequestMethod.POST)
    public @ResponseBody
    Result delete(BlackList blackList){
        int a = blackListBiz.delete(blackList);
        return Result.ok(a);
    }
//将客户添加到黑名单中
    @RequestMapping(value = {"/create"},method = RequestMethod.POST)
    public @ResponseBody
    Result create(@RequestBody BlackList blackList){
        int a = blackListBiz.create(blackList);
        return Result.ok(a);
    }
}
