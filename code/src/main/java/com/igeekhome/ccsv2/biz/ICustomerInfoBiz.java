package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerInfo;

import java.util.HashMap;

public interface ICustomerInfoBiz {
    int create(CustomerInfo customerInfo);

    HashMap<String, Integer> createId();

    int delete(CustomerInfo customerInfo);
}
