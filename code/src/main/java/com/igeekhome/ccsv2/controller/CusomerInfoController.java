package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerInfoBiz;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/cInfo")
public class CusomerInfoController {

    @Autowired
    private ICustomerInfoBiz customerInfoBiz;

    @RequestMapping(value = {"/create"},method = RequestMethod.POST)//创建客户
    public @ResponseBody Result creat(CustomerInfo customerInfo){
        HashMap<String, Integer> t = customerInfoBiz.createId();
        int v = t.get("MAX(customer_id)") + 1;
        customerInfo.setcustomerId(v);
        int a = customerInfoBiz.create(customerInfo);
        return Result.ok(a);
    }

    @RequestMapping(value = {"/delete"},method = RequestMethod.POST)//删除客户
    public @ResponseBody Result delete(CustomerInfo customerInfo){
        int a = customerInfoBiz.delete(customerInfo);
        return Result.ok(a);
    }

    @RequestMapping(value = {"/select"},method = RequestMethod.POST)//模糊搜索客户信息表
    @ResponseBody
    public Result select() {
        CustomerInfo customerInfo = new CustomerInfo();
        List<CustomerInfo> customerInfos = customerInfoBiz.select(customerInfo);
        return Result.ok(customerInfos);
    }

    @RequestMapping(value = {"/selectByDate"},method = RequestMethod.POST)//根据日期时间段搜索客户信息表
    @ResponseBody
    public Result selectByDate() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = dateformat.parse("2020-7-4");
        Date endTime = dateformat.parse("2020-7-8");
        List<CustomerInfo> customerInfos = customerInfoBiz.selectByDate(beginTime,endTime);
        return Result.ok(customerInfos);
    }
}
