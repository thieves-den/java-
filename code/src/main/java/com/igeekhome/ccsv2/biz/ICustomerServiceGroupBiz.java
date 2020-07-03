package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerServiceGroup;

public interface ICustomerServiceGroupBiz {
    public int save(CustomerServiceGroup group);
    public CustomerServiceGroup getOne(String name);

    int delete(int id);
}