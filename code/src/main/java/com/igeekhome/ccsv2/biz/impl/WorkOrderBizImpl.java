package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.IWorkOrderBiz;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.WorkOrder;
import com.igeekhome.ccsv2.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class WorkOrderBizImpl implements IWorkOrderBiz {
    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Override
    public int create(WorkOrder workOrder) {
        return workOrderMapper.create(workOrder);
    }

    @Override
    public HashMap<String, Integer> findId() {
        return workOrderMapper.findId();
    }

    @Override
    public List<WorkOrder> select(WorkOrder workOrder) {
        return workOrderMapper.select(workOrder);
    }

    @Override
    public List<WorkOrder> selectByDate(Date begin, Date end) {
        return workOrderMapper.selectByDate(begin, end);
    }

    @Override
    public List<WorkOrder> historyWorkOrder(CustomerInfo customerInfo) {
        return workOrderMapper.historyWorkOrder(customerInfo);
    }
}
