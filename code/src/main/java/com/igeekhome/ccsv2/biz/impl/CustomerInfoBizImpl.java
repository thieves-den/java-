package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ICustomerInfoBiz;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class CustomerInfoBizImpl implements ICustomerInfoBiz {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Override
    public int create(CustomerInfo customerInfo) {
        return customerInfoMapper.create(customerInfo);
    }

    @Override
    public HashMap<String, Integer> createId() {
        return customerInfoMapper.createId();
    }
}
