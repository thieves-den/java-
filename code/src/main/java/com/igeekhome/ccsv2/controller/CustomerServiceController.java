package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.entity.CustomerServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/cs")
public class CustomerServiceController {
    //依赖业务层接口对象
    @Autowired
    private ICustomerServiceBiz customerServiceBiz;

//注册新客服
    @RequestMapping(value = {"/register"})
    @ResponseBody
    public String register(){
        CustomerService cs = new CustomerService();
        cs.setPhone("13572");
        cs.setPassword("qwerasdf");
        int a = customerServiceBiz.register(cs);
        return a+"successfully";
    }
//管理员新增客服信息
    @RequestMapping(value = {"/register"})
    @ResponseBody
    public String addNewCustomerService(){
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
        return a+"successfully";
    }

//更新个人信息部分
    @RequestMapping(value =  {"/update"},method = RequestMethod.POST)
    public @ResponseBody String update(CustomerService oldcs, CustomerService newcs){
        int a = customerServiceBiz.update(oldcs,newcs);
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

//分组查询客服信息
    @RequestMapping(value = {"/showByGroup"})
    @ResponseBody
    public String showByGroup(){
        CustomerServiceGroup group = new CustomerServiceGroup();
        group.setId(2);
        group.setGroupName("客服二组");
        List<CustomerService> csList = customerServiceBiz.showByGroup(group);;

        return "查询共返回" + csList.size() + "个客服信息：" + csList;
    }

//模糊搜索客服信息（客服管理界面）
    @RequestMapping(value = {"/query"})
    @ResponseBody
    public String search(){
        CustomerService cs = new CustomerService();
        List<CustomerService> csList = new ArrayList<CustomerService>();
        Scanner sc = new Scanner (System.in);
        String input = sc.next();//
        //输入为id时
        try {
            int id = Integer.parseInt(input);
            cs.setId(id);
            csList = customerServiceBiz.queryFuzzy(cs);
        }
        catch (Exception e){}
        //输入为电话号（账号）时
        cs.setPhone(input);
        csList = customerServiceBiz.queryFuzzy(cs);
        //输入为真实名字时
        cs.setRealName(input);
        csList = customerServiceBiz.queryFuzzy(cs);
        //输入为昵称时
        cs.setNickName(input);
        csList = customerServiceBiz.queryFuzzy(cs);
        //输入为邮箱时
        cs.setEmail(input);
        csList = customerServiceBiz.queryFuzzy(cs);

        return "查询共返回" + csList.size() + "个客服信息：" + csList;
    }

//根据客服id删除单个客服信息
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public String deleteById() {
        Integer id = null;
        int a = customerServiceBiz.deleteById(id);
        return "delete successfully";
    }
//批量删除客服信息
    @RequestMapping(value = {"deleteBatch"})
    @ResponseBody
    public String deleteBatch() {
        List<Integer> ids = new ArrayList<>();
        //ids.add(1);
        //ids.add(2);
        //ids.add(3);
        int a = customerServiceBiz.deleteBatch(ids);
        return "deleteBatch successfully";
    }
}
