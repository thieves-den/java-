package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IBlackListBiz;
import com.igeekhome.ccsv2.entity.BlackList;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp time = Timestamp.valueOf(dateFormat.format(new Date()));//获取当前时间
        blackList.setCreateTime(time);
        int a = blackListBiz.create(blackList);
        return Result.ok(a);
    }


    //客户详情页面拉黑记录表，根据customerId
    @RequestMapping(value = "/blackRecord",method = RequestMethod.GET)
    @ResponseBody
    public Result blackRecord(CustomerInfo customerInfo){
        List<BlackList> blackLists = blackListBiz.showBlackRecord(customerInfo);
        return Result.ok(blackLists);
    }
}
