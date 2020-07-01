package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerInfoBiz;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("cInfo")
public class CusomerInfoController {

    @Autowired
    private ICustomerInfoBiz customerInfoBiz;

    @RequestMapping(value = {"/create"},method = RequestMethod.POST)
    public @ResponseBody String creat(CustomerInfo customerInfo){
        HashMap<String, Integer> t = customerInfoBiz.createId();
        int v = t.get("MAX(customer_id)") + 1;
        customerInfo.setcustomerId(v);
        int a = customerInfoBiz.create(customerInfo);
        return a + "";
    }
}
