package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ICustomerInfoBiz {
    int create(CustomerInfo customerInfo);
    HashMap<String, Integer> createId();

    //客户信息表搜索
    List<CustomerInfo> select(CustomerInfo customerInfo);
    List<CustomerInfo> selectByDate(Date begin, Date end);

    int delete(CustomerInfo customerInfo);
}
