package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ICustomerServiceBiz {

    /**
     * 注册客服以及管理员新增客服信息
     */
    int register(CustomerService cs);
    int addNewCustomerService(CustomerService cs);

    /**
     * 根据id、电话、姓名等条件查询，返回查询对象List
     */
    List<CustomerService> queryFuzzy(CustomerService cs);
    List<CustomerService> showByGroup(CustomerServiceGroup group);

    int update(CustomerService cs);

    int updatePwd(CustomerService cs);

    HashMap<String, String> findPwd(CustomerService cs);

    int deleteById(int id);//删除单个
    int deleteBatch(List<Integer> ids);//批量删除

    CustomerService login(CustomerService cs);

    List<CustomerService> queryWorkload(CustomerService cs);

    List<CustomerService> queryCheckingIn(CustomerService cs);

    List<CustomerService> queryWorkQuality(CustomerService cs);
}