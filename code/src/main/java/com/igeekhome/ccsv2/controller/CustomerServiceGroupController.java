package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceGroupBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("/csgroup")
public class CustomerServiceGroupController {

    @Autowired
    private ICustomerServiceGroupBiz customerServiceGroupBiz;
    /**
     * 对外提供保存创建客服组的服务
     */
    @RequestMapping(value = {"/save"},method = RequestMethod.POST)
    public @ResponseBody String save(CustomerServiceGroup group){
        int a = customerServiceGroupBiz.save(group);
        return a+"";
    }
    /**
     * 对外提供删除客服组的服务
     */
    public String delete(int id){
        return "ok";
    }


    /**
     * 对外提供根据id查询客服组的服务
     */
    @GetMapping("/getCustomerServiceGroup/{id}")
    @ResponseBody
    public CustomerServiceGroup qieryById(@PathVariable int id){
        CustomerServiceGroup group = customerServiceGroupBiz.getOne(id);
        return group;
    }
    /**
     * 对外提供编辑客服组的服务
     */
    public String edit(CustomerServiceGroup group){
        return "OK";
    }
    /**
     * 对外提供查询客服组的服务
     */
    public String adfad(List<CustomerServiceGroup> groups){
        return "OK";
    }
}
