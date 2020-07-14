package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.VisitorInfo;
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
    CustomerInfoBizImpl customerInfoBiz;

    @Test
    void selectCustomerSession() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setcustomerId(1);
        List<VisitorInfo> visitorInfos = customerInfoBiz.selectCustomerSession(customerInfo);
        System.out.println(visitorInfos.size()+":"+visitorInfos);
    }

    @Test
    void selectByDate() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = dateformat.parse("2020-7-6");
        Date endTime = dateformat.parse("2020-7-9");
        List<CustomerInfo> customerInfos = customerInfoBiz.selectByDate(beginTime, endTime);
        System.out.println(customerInfos.size());
    }

    @Test
    void select(){
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setRealName("王");
        List<CustomerInfo> customerInfos = customerInfoBiz.select(customerInfo);
        System.out.println(customerInfos.size()+":"+customerInfos);
    }
}