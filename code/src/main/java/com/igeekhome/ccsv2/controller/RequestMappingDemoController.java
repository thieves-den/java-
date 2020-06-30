package com.igeekhome.ccsv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class RequestMappingDemoController {

    @RequestMapping(value = {"/demo1","/*/abc","/demo1/{id}"},
            method = {RequestMethod.POST},params = {"name"},
            consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public String demo1(@PathVariable(name = "id") String id, String name, @RequestHeader(name="token") String token){
        return "一个处理器可以处理多个不同路径的请求" + name + "当前请求的值是token"+ token;
    }
}
