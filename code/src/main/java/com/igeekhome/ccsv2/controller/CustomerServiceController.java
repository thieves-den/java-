package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cs")
public class CustomerServiceController {

    @Autowired
    private ICustomerServiceBiz customerServiceBiz;

    @RequestMapping(value =  {"/update"},method = RequestMethod.POST)
    public @ResponseBody String update(CustomerService service){
        int a = customerServiceBiz.update(service);
        return a+"";
    }
}
