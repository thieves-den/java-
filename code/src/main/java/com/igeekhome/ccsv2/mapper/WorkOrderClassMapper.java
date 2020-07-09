package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.WorkOrderClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WorkOrderClassMapper {
    int createClass(WorkOrderClass woc);

    List<WorkOrderClass> queryByName(String name);

    int deleteById(int id);//删除单个
    int deleteBatch(List<Integer> ids);//批量删除
}
