package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.WorkOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface IWorkOrderBiz {
    int create(WorkOrder workOrder);
    HashMap<String, Integer> findId();

    //工单列表
    List<WorkOrder> select(WorkOrder workOrder);//模糊查找
    List<WorkOrder> selectByDate(Date begin, Date end);//根据日期时间段查找
}
