package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.WorkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface WorkOrderMapper {
    int create(WorkOrder workOrder);
    HashMap<String, Integer> findId();

    //工单列表
    List<WorkOrder> select(WorkOrder workOrder);//模糊查找
    List<WorkOrder> selectByDate(@Param("begin") Date begin, @Param("end") Date end);//根据日期时间段查找

    //客户详情中历史工单表
    List<WorkOrder> historyWorkOrder(CustomerInfo customerInfo);
}
