package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.IWorkOrderClassBiz;
import com.igeekhome.ccsv2.entity.WorkOrderClass;
import com.igeekhome.ccsv2.mapper.WorkOrderClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderClassBizImpl implements IWorkOrderClassBiz {

    @Autowired
    //依赖的持久化层对象
    private WorkOrderClassMapper workOrderClassMapper;

    @Override
    public int createClass(WorkOrderClass woc) {
        return workOrderClassMapper.createClass(woc);
    }

    @Override
    public List<WorkOrderClass> queryByName(WorkOrderClass woc) {
        return workOrderClassMapper.queryByName(woc.getClassName());
    }


    @Override
    public int deleteById(int id) {
        return workOrderClassMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return workOrderClassMapper.deleteBatch(ids);
    }
}
