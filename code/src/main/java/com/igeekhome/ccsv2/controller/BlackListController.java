package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IBlackListBiz;
import com.igeekhome.ccsv2.entity.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bl")
public class BlackListController {

    @Autowired
    private IBlackListBiz blackListBiz;
    /**
     * 解除客户黑名单的功能
     */
    @RequestMapping(value = {"/delete"},method = RequestMethod.POST)
    public @ResponseBody
    String delete(BlackList blackList){
        int a = blackListBiz.delete(blackList);
        return a + "";
    }
//将客户添加到黑名单中
    @RequestMapping(value = {"/create"},method = RequestMethod.POST)
    public @ResponseBody
    String create(BlackList blackList){
        int a = blackListBiz.create(blackList);
        return a + "";
    }
}
