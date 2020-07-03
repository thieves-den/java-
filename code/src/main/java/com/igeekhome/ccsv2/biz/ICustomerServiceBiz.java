package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerService;

import java.util.HashMap;

public interface ICustomerServiceBiz {

    /**
     * 根据id查询，返回单一查询对象
     */
    CustomerService queryById(int id);

    int update(CustomerService cs);

    int updatePwd(CustomerService cs);

    HashMap<String, String> findPwd(CustomerService cs);
}