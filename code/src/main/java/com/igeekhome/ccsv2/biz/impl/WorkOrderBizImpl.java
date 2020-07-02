package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.IWorkOrderBiz;
import com.igeekhome.ccsv2.entity.WorkOrder;
import com.igeekhome.ccsv2.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
}
