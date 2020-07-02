package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

@Controller
@RequestMapping("/cs")
public class CustomerServiceController {

    @Autowired
    private ICustomerServiceBiz customerServiceBiz;
//更改个人信息部分
    @RequestMapping(value =  {"/update"},method = RequestMethod.POST)
    public @ResponseBody String update(CustomerService service){
        int a = customerServiceBiz.update(service);
        return a+"";
    }
//更改密码
    @RequestMapping(value =  {"/update/pwd"},method = RequestMethod.POST)
    public @ResponseBody String updatePwd(String customerServiceId,String oldPwd, String newPwd,String twNewPwd){
        CustomerService service = new CustomerService();
        service.setCustomerServiceId(customerServiceId);
        service.setPassword(oldPwd);

        HashMap<String,String> a = customerServiceBiz.findPwd(service);
        String truePassword=a.get("password");//查找正确密码
        if(!Objects.equals(truePassword, oldPwd)){
            return "密码错误";
        }else if(!Objects.equals(newPwd, twNewPwd)){
            return "两次输入的密码不相同";
        }else {
            service.setPassword(newPwd);
            int t=customerServiceBiz.updatePwd(service);
            return t + "";
        }
    }
}
