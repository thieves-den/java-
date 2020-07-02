package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.WorkOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface WorkOrderMapper {
    int create(WorkOrder workOrder);

    HashMap<String, Integer> findId();
}
