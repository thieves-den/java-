package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ICustomerServiceBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.mapper.CustomerServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceBizImpl implements ICustomerServiceBiz {
    @Autowired
    //依赖的持久化层对象
    private CustomerServiceMapper customerServiceMapper;

    @Override
    public int register(CustomerService cs) {
        return customerServiceMapper.save(cs);
    }
    @Override
    public int addNewCustomerService(CustomerService cs) {
        return customerServiceMapper.save(cs);
    }

    @Override
    public List<CustomerService> queryFuzzy(CustomerService cs) {
        return customerServiceMapper.queryFuzzy(cs);
    }

    @Override
    public List<CustomerService> showByGroup(CustomerServiceGroup group) {
        return customerServiceMapper.showByGroup(group);
    }

    @Override
    public int update(CustomerService oldcs, CustomerService newcs) {
        return customerServiceMapper.update(oldcs, newcs);
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
    public int deleteById(int id) {
        return customerServiceMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return customerServiceMapper.deleteBatch(ids);
    }
}
