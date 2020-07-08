package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.WorkOrderClass;

import java.util.List;

public interface IWorkOrderClassBiz {
    int createClass(WorkOrderClass woc);

    List<WorkOrderClass> queryByName(WorkOrderClass woc);

    int deleteById(int id);//删除单个
    int deleteBatch(List<Integer> ids);//批量删除
}
