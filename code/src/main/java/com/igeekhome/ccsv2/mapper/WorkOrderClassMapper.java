package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.WorkOrderClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WorkOrderClassMapper {
    int createClass(WorkOrderClass woc);

    List<WorkOrderClass> queryByName(String name);

    int deleteBatch(List<Integer> ids);//删除工单类别
}
