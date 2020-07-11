package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ICustomerInfoBiz;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.VisitorInfo;
import com.igeekhome.ccsv2.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


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


    @Override
    public List<CustomerInfo> select(CustomerInfo customerInfo) {
        return customerInfoMapper.select(customerInfo);
    }


    @Override
    public List<VisitorInfo> selectCustomerSession(CustomerInfo customerInfo) {
        return customerInfoMapper.selectCustomerSession(customerInfo);
    }

    @Override
    public int update(CustomerInfo customerInfo) {
        return customerInfoMapper.update(customerInfo);
    }

    @Override
    public int delete(CustomerInfo customerInfo) {
        return customerInfoMapper.delete(customerInfo);
    }


    @Override
    public List<CustomerInfo> selectByDate(Date begin, Date end) {
        return customerInfoMapper.selectByDate(begin, end);
    }
}
