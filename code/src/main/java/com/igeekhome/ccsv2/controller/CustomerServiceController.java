package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

@Controller
@RequestMapping("/cs")
@CrossOrigin
public class CustomerServiceController {

    @Autowired
    private ICustomerServiceBiz customerServiceBiz;
    //更改个人信息部分
    @RequestMapping(value =  {"/update"},method = RequestMethod.POST)
    public @ResponseBody String update(CustomerService cs){
        int a = customerServiceBiz.update(cs);
        return a+"";
    }
    //更改密码
    @RequestMapping(value =  {"/update/pwd"},method = RequestMethod.POST)
    public @ResponseBody String updatePwd(int id,String oldPwd, String newPwd,String twNewPwd){
        CustomerService cs = new CustomerService();
        cs.setId(id);
        cs.setPassword(oldPwd);

        HashMap<String,String> a = customerServiceBiz.findPwd(cs);
        String truePassword=a.get("password");//查找正确密码
        if(!Objects.equals(truePassword, oldPwd)){
            return "密码错误";
        }else if(!Objects.equals(newPwd, twNewPwd)){
            return "两次输入的密码不相同";
        }else {
            cs.setPassword(newPwd);
            int t=customerServiceBiz.updatePwd(cs);
            return t + "";
        }
    }
    @CrossOrigin
    @RequestMapping(value =  {"/regist"},method = RequestMethod.POST)
    public @ResponseBody String resign(@RequestBody CustomerService customerService){
        int a = customerServiceBiz.resign(customerService);
        return a+"";
        //return customerService.getCustomerServicePhone()+" "+customerService.getPassword();
    }
}
