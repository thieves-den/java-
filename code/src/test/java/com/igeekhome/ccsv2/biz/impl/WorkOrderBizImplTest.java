package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.WorkOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WorkOrderBizImplTest {
    @Autowired
    WorkOrderBizImpl workOrderBiz;

    @Test
    void select() {
        WorkOrder workOrder = new WorkOrder();
        List<WorkOrder> workOrders = workOrderBiz.select(workOrder);
        System.out.println("查询共返回"+workOrders.size()+"个工单："+workOrders);
    }

    @Test
    void selectByDate() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = dateformat.parse("2020-7-4");
        Date endTime = dateformat.parse("2020-7-8");
        List<WorkOrder> workOrders = workOrderBiz.selectByDate(beginTime,endTime);
        System.out.println("查询共返回"+workOrders.size()+"个工单："+workOrders);
    }

}