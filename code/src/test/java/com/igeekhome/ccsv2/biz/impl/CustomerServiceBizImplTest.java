package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceBizImplTest {

    @Autowired
    private CustomerServiceBizImpl customerServiceBizImpl;

    @Test
    void queryById() {
        CustomerService cs = customerServiceBizImpl.queryById(1);
        System.out.println(cs);
        assertNotNull(cs);
    }
}