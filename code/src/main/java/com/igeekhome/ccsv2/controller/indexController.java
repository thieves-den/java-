package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.entity.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    //处理客户端请求
    @RequestMapping("/")
    public @ResponseBody String index(){
        return "ok2";
    }

    @RequestMapping(value="/cs")
    public @ResponseBody CustomerService query(){
        CustomerService cs = new CustomerService();
        cs.setNickName("小张");
        cs.setRealName("张张1");
        return cs;
    }
}
