package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.entity.CustomerService;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {
//处理客服端请求
    @RequestMapping("/")
    public @ResponseBody String index(){
        return "OK2";
    }
    @RequestMapping("/abc")
    public @ResponseBody CustomerService query(){
        CustomerService cs = new CustomerService();
        cs.setNickName("小张");
        cs.setRealName("张三");
        return cs;
    }
}
