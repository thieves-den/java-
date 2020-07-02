package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.WorkOrder;

import java.util.HashMap;

public interface IWorkOrderBiz {
    int create(WorkOrder workOrder);

    HashMap<String, Integer> findId();
}
