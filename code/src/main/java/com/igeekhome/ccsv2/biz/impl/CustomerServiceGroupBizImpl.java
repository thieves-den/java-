package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ICustomerServiceGroupBiz;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.mapper.CustomerServiceGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceGroupBizImpl implements ICustomerServiceGroupBiz {
    @Autowired
    private CustomerServiceGroupMapper serviceGroupMapper;
    @Override
    public int save(CustomerServiceGroup group) {
        return serviceGroupMapper.save(group);
    }

    @Override
    public CustomerServiceGroup getOne(int id) {
        return serviceGroupMapper.getOne(id);
    }
}
