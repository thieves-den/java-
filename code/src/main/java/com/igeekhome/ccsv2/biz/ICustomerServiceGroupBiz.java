package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;

public interface ICustomerServiceGroupBiz {
    public int save(CustomerServiceGroup group);

    CustomerServiceGroup getOne(int id);
}
