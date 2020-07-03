package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.mapper.CustomerServiceGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceGroupBizImpl implements com.igeekhome.ccsv2.biz.ICustomerServiceGroupBiz {
    @Autowired
    private CustomerServiceGroupMapper serviceGroupMapper;
    @Override
    public int save(CustomerServiceGroup group) {
        return serviceGroupMapper.save(group);
    }
    @Override
    public CustomerServiceGroup getOne(String name) {
        return serviceGroupMapper.getOne(name);
    }

    @Override
    public int delete(int id) {
        return serviceGroupMapper.delete(id);
    }

    @Override
    public int edit(int id, String name) {
        return serviceGroupMapper.edit(id,name);
    }
}