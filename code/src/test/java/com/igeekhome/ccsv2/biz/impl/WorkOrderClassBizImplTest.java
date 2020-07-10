package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.WorkOrderClass;
import com.igeekhome.ccsv2.untils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WorkOrderClassBizImplTest {
    //依赖业务层对象
    @Autowired
    private WorkOrderClassBizImpl workOrderClassBizImpl;

    @Test
    void createClass() {
        WorkOrderClass woc = new WorkOrderClass();
        woc.setClassName("咨询相关工单");
        int a = workOrderClassBizImpl.createClass(woc);
        assertNotEquals(0,a);
    }

    @Test
    void queryByName() {
        WorkOrderClass woc = new WorkOrderClass();
        //woc.setClassName("推广");
        List<WorkOrderClass> wocList = workOrderClassBizImpl.queryByName(woc);
        System.out.println("查询共返回" + wocList.size() + "种工单类别：" + wocList);
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteBatch() {
    }
}