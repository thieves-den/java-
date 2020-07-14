package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceGroupBiz;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/csgroup")
public class CustomerServiceGroupController {
//    添加依赖声明
    @Autowired
    private ICustomerServiceGroupBiz customerServiceGroupBiz;
    /**
    * 对外提供创建客服组的服务
    */
    @RequestMapping(value = {"/save"},method = RequestMethod.POST)
    public @ResponseBody Result save(CustomerServiceGroup group){
        Date date = new Date();
        //date = dateformat.parse("2020-7-6 12:09:36"); ——>Date赋值语句
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp time = Timestamp.valueOf(dateFormat.format(date));//获取当前时间
        group.setCreateTime(time);
        int a = customerServiceGroupBiz.save(group);
        return Result.ok(a);
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
    @GetMapping(value = "/getCustomerServiceGroup/{id}")
    @ResponseBody
    public CustomerServiceGroup queryById(@PathVariable int id){
        CustomerServiceGroup group= customerServiceGroupBiz.getOne(id);

        return group;
    }
    /**
     * 对外提供保存编辑客服组结果的服务
     */
    public String edit(CustomerServiceGroup group){

        return  "ok";
    }
    /**
     * 对外提供查询客服组的服务
     */
    public List<CustomerServiceGroup> query(){
        List<CustomerServiceGroup> groups = null;

        return groups;
    }
}

