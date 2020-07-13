package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.entity.CustomerServiceRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceBizImplTest {
    //依赖业务层对象
    @Autowired
    private CustomerServiceBizImpl customerServiceBizImpl;

    @Test
    void register(){
        CustomerService cs = new CustomerService();
        cs.setPhone("135722");
        cs.setPassword("qwdf");
        int a = customerServiceBizImpl.register(cs);
        assertNotEquals(0,a);
    }

    @Test
    void addNewCustomerService(){
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
        int a = customerServiceBizImpl.register(cs);
        assertNotEquals(0,a);
    }

    @Test
    void queryFuzzy(){  //可以根据id、phone、名字等一个或多个属性进行客服信息模糊查询
        CustomerService cs = new CustomerService();
        //cs.setId(1);
        //cs.set...
        List<CustomerService> csList = customerServiceBizImpl.queryFuzzy(cs);
        System.out.println("查询共返回" + csList.size() + "个客服信息：" + csList);
        assertNotNull(csList);
    }

    @Test
    void showByGroup(){
        CustomerServiceGroup group = new CustomerServiceGroup();
        group.setId(1);
        //group.setName("客服一组");
        System.out.println(group);
        List<CustomerService> csList = customerServiceBizImpl.showByGroup(group);
        System.out.println("查询共返回" + csList.size() + "个客服信息：" + csList);
        assertNotNull(csList);
    }


}