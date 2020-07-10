package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.VisitorInfo;
import com.igeekhome.ccsv2.untils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VisitorInfoImplTest {
    @Autowired
    private VisitorInfoImpl visitorInfoBiz;

    @Test
    void select() {
        VisitorInfo visitorInfo = new VisitorInfo();
        List<VisitorInfo> visitor = visitorInfoBiz.select(visitorInfo);
        System.out.println(visitor);
        assertNotNull(visitor);
    }
}