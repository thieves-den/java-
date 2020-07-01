package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerService;

import java.util.HashMap;

public interface ICustomerServiceBiz {
    int update(CustomerService service);

    int updatePwd(CustomerService service);

    HashMap<String, String> findPwd(CustomerService service);
}
