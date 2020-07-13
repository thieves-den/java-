package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.VisitorInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ICustomerInfoBiz {
    int create(CustomerInfo customerInfo);
    HashMap<String, Integer> createId();

    //客户信息表搜索
    List<CustomerInfo> select(CustomerInfo customerInfo);
    List<CustomerInfo> selectByDate(Date begin,Date end);


    //客户详情中历史会话表（客户的访问信息）
    List<VisitorInfo> selectCustomerSession(CustomerInfo customerInfo);

    //根据customerId定位编辑修改客户信息
    int update(CustomerInfo customerInfo);

    int delete(CustomerInfo customerInfo);


    int getIdByNickName(CustomerInfo nickName);

    CustomerInfo selectByNickName(CustomerInfo customerInfo);
}
