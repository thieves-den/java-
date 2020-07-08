package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.mapper.CustomerServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CustomerServiceBizImpl implements ICustomerServiceBiz {
    @Autowired
    //依赖的持久化层对象
    private CustomerServiceMapper customerServiceMapper;

    @Override
    public CustomerService queryById(int id) {
        return customerServiceMapper.queryById(id);
    }

    @Override
    public int update(CustomerService cs){
        return customerServiceMapper.update(cs);
    }

    @Override
    public int updatePwd(CustomerService cs) {
        return customerServiceMapper.updatePwd(cs);
    }

    @Override
    public HashMap<String, String> findPwd(CustomerService cs) {
        return customerServiceMapper.findPwd(cs);
    }

    @Override
    public int resign(CustomerService customerService) {
        return customerServiceMapper.resign(customerService);
    }


}
