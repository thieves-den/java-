package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.WorkOrderClass;

import java.util.List;

public interface IWorkOrderClassBiz {
    int createClass(WorkOrderClass woc);

    List<WorkOrderClass> queryByName(WorkOrderClass woc);

    int deleteBatch(List<Integer> ids);//删除
}
