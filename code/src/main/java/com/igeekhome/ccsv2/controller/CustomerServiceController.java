package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.entity.CustomerServiceRole;
import com.igeekhome.ccsv2.untils.Result;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("/cs")
public class CustomerServiceController {
    //依赖业务层接口对象
    @Autowired
    private ICustomerServiceBiz customerServiceBiz;

    //注册新客服
    @RequestMapping(value = {"/register"})
    @ResponseBody
    public Result register(){
        CustomerService cs = new CustomerService();
        cs.setPhone("13572");
        cs.setPassword("qwerasdf");
        int a = customerServiceBiz.register(cs);
        return Result.ok(a);
    }
    //管理员新增客服信息
    @RequestMapping(value = {"/addNewCustomerService"})
    @ResponseBody
    public Result addNewCustomerService(){
        CustomerService cs = new CustomerService();
        CustomerServiceGroup group = new CustomerServiceGroup();
        CustomerServiceRole role = new CustomerServiceRole();
        cs.setEmail("168@qq.com");
        cs.setNickName("小尼哥");
        cs.setRealName("尼格买提");
        cs.setId(15);
        cs.setPhone("13388");
        cs.setPassword("123456");//设置初始密码

        role.setId(1);
        cs.setRole(role);

        group.setId(4);
        cs.setGroup(group);

        cs.setServiceCap(10000);
        int a = customerServiceBiz.register(cs);
        return Result.ok(a);
    }

    //更新个人信息部分
    @RequestMapping(value =  {"/update"},method = RequestMethod.POST)
    public @ResponseBody Result update(CustomerService oldcs, CustomerService newcs){
        int a = customerServiceBiz.update(oldcs,newcs);
        return Result.ok(a);
    }

    //更改密码
    @RequestMapping(value =  {"/update/pwd"},method = RequestMethod.POST)
    public @ResponseBody Result updatePwd(int id,String oldPwd, String newPwd,String twNewPwd){
        CustomerService cs = new CustomerService();
        cs.setId(id);
        cs.setPassword(oldPwd);

        HashMap<String,String> a = customerServiceBiz.findPwd(cs);
        String truePassword=a.get("password");//查找正确密码
        if(!Objects.equals(truePassword, oldPwd)){
            return Result.error("密码错误");
        }else if(!Objects.equals(newPwd, twNewPwd)){
            return Result.error("两次输入的密码不相同");
        }else {
            cs.setPassword(newPwd);
            int t=customerServiceBiz.updatePwd(cs);
            return Result.ok(t);
        }
    }

    //首页客服监控，返回在线客服信息
    @GetMapping("/CustomerServiceMonitor")
    @ResponseBody
    public Result CustomerServiceMonitor(){
        CustomerService cs = new CustomerService();
        cs.setOnlineState(1);
        List<CustomerService> csList = customerServiceBiz.queryFuzzy(cs);
        return Result.ok(csList);
    }

    //分组查询客服信息
    @GetMapping("/showByGroup")
    @ResponseBody
    public Result showByGroup(){
        CustomerServiceGroup group = new CustomerServiceGroup();
        group.setId(1);
        group.setName("客服二组");
        List<CustomerService> csList = customerServiceBiz.showByGroup(group);
        return Result.ok(csList);
    }

    //模糊搜索客服信息（客服管理界面）
    @RequestMapping(value = {"/query"})
    @ResponseBody
    public Result search(){
        CustomerService cs = new CustomerService();
        List<CustomerService> csList = new ArrayList<CustomerService>();
        Scanner sc = new Scanner (System.in);
        String input = sc.next();
        //输入为id时
        try {
            int id = Integer.parseInt(input);
            cs.setId(id);
            csList.addAll(customerServiceBiz.queryFuzzy(cs));
        }
        catch (Exception e){}
        //输入为电话号（账号）时
        cs.setPhone(input);
        csList.addAll(customerServiceBiz.queryFuzzy(cs));
        //输入为真实名字时
        cs.setRealName(input);
        csList.addAll(customerServiceBiz.queryFuzzy(cs));
        //输入为昵称时
        cs.setNickName(input);
        csList.addAll(customerServiceBiz.queryFuzzy(cs));
        //输入为邮箱时
        cs.setEmail(input);
        csList.addAll(customerServiceBiz.queryFuzzy(cs));

        return Result.ok(csList);
    }

    //根据客服id删除单个客服信息
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public Result deleteById() {
        Integer id = null;
        int a = customerServiceBiz.deleteById(id);
        return Result.ok(a);
    }
    //批量删除客服信息
    @RequestMapping(value = {"deleteBatch"})
    @ResponseBody
    public Result deleteBatch() {
        List<Integer> ids = new ArrayList<>();
        //ids.add(1);
        //ids.add(2);
        //ids.add(3);
        int a = customerServiceBiz.deleteBatch(ids);
        return Result.ok(a);
    }
}
