package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceGroupBiz;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/csgroup")
public @ResponseBody class CustomerServiceGroupController {
    @Autowired
    private ICustomerServiceGroupBiz customerServiceGroupBiz;

    @RequestMapping(value = "/save",method = {RequestMethod.POST},params = {"name"})
    public @ResponseBody String save(CustomerServiceGroup group,String name){
        group.setGroupName(name);
        int a=customerServiceGroupBiz.save(group);
        return a+"";
    }
    @RequestMapping(value = "/getOne",method = {RequestMethod.GET},params = {"name"})
    @ResponseBody
    public CustomerServiceGroup getOne(String name){
        CustomerServiceGroup group=customerServiceGroupBiz.getOne(name);
        return group;
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE,params = "id")
    @ResponseBody
    public int delete(int id){
        return customerServiceGroupBiz.delete(id);
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST,name="id,name")
    @ResponseBody
    public int edit(int id,String name){
        return customerServiceGroupBiz.edit(id,name);
    }

}
