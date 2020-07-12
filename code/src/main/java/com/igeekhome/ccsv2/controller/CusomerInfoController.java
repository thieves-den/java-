package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IBlackListBiz;
import com.igeekhome.ccsv2.biz.ICustomerInfoBiz;
import com.igeekhome.ccsv2.entity.BlackList;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.VisitorInfo;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/cInfo")
public class CusomerInfoController {

    @Autowired
    private ICustomerInfoBiz customerInfoBiz;



    @RequestMapping(value = {"/create"},method = RequestMethod.POST)//创建客户
    public @ResponseBody Result creat(@RequestBody CustomerInfo customerInfo){
        HashMap<String, Integer> t = customerInfoBiz.createId();
        int v = t.get("MAX(customer_id)") + 1;
        customerInfo.setcustomerId(v);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp time = Timestamp.valueOf(dateFormat.format(date));//获取当前时间
        customerInfo.setCreateTime(time);
        int a = customerInfoBiz.create(customerInfo);
        return Result.ok(a);
    }

    //根据customerId定位编辑修改客户信息
    @RequestMapping(value = {"/update"},method = RequestMethod.POST)
    @ResponseBody
    public Result update(CustomerInfo customerInfo){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp time = Timestamp.valueOf(dateFormat.format(date));//获取当前时间
        customerInfo.setUpdateTime(time);
        int a = customerInfoBiz.update(customerInfo);
        return Result.ok(a);
    }

    //模糊搜索客户信息表
    @RequestMapping(value = {"/select"},method = RequestMethod.GET)
    @ResponseBody
    public Result select(CustomerInfo customerInfo) {
        List<CustomerInfo> customerInfos = customerInfoBiz.select(customerInfo);
        return Result.ok(customerInfos);
    }

    //根据日期时间段搜索客户信息表
    @RequestMapping(value = {"/selectByDate"},method = RequestMethod.GET)
    @ResponseBody
    public Result selectByDate(Date begin, Date end) throws ParseException {
        List<CustomerInfo> customerInfos = customerInfoBiz.selectByDate(begin, end);
        return Result.ok(customerInfos);
    }


    //客户详情中历史会话表（客户的访问信息），根据customerId
    @RequestMapping(value = "/historyCustomerSession",method = RequestMethod.GET)
    @ResponseBody
    public Result historyCustomerSession(CustomerInfo customerInfo){
        List<VisitorInfo> visitorInfos = customerInfoBiz.selectCustomerSession(customerInfo);
        return Result.ok(visitorInfos);
    }

    //客户详情页面拉黑记录表在BlackListController


    //删除客户
    @RequestMapping(value = {"/delete"},method = RequestMethod.POST)
    public @ResponseBody Result delete(CustomerInfo customerInfo){
        int a = customerInfoBiz.delete(customerInfo);
        return Result.ok(a);
    }
}
