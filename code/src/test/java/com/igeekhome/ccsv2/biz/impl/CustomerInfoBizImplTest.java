package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CustomerInfoBizImplTest {
    @Autowired
    private CustomerInfoBizImpl customerInfoBiz;

    @Test
    void select() {
        CustomerInfo customerInfo = new CustomerInfo();
        List<CustomerInfo> customerInfos = customerInfoBiz.select(customerInfo);
        System.out.println(customerInfos.size()+" "+customerInfos);
    }

    @Test
    void selectByDate() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = dateformat.parse("2020-7-4");
        Date endTime = dateformat.parse("2020-7-8");
        List<CustomerInfo> customerInfos = customerInfoBiz.selectByDate(beginTime,endTime);
        System.out.println(customerInfos.size()+" "+customerInfos);
    }
}