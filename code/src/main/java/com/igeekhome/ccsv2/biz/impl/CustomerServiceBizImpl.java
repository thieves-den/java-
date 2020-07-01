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
    private CustomerServiceMapper serviceMapper;

    //@Override
    public int update(CustomerService service){
        return serviceMapper.update(service);
    }

    @Override
    public int updatePwd(CustomerService service) {
        return serviceMapper.updatePwd(service);
    }

    @Override
    public HashMap<String, String> findPwd(CustomerService service) {
        return serviceMapper.findPwd(service);
    }
}
