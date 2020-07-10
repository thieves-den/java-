package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IWorkOrderClassBiz;
import com.igeekhome.ccsv2.entity.WorkOrderClass;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/workOrderClass")
public class WorkOrderClassController {
    //依赖业务层接口对象
    @Autowired
    private IWorkOrderClassBiz workOrderClassBiz;

    //查询工单类别,工单分类表
    @GetMapping(value = "/query")
    @ResponseBody
    public Result queryByName(WorkOrderClass woc){
        woc.setClassName("推广");
        List<WorkOrderClass> wocList = workOrderClassBiz.queryByName(woc);
        return Result.ok(wocList);
    }

    //新建工单类别
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Result createClass(WorkOrderClass woc){
        woc.setClassName("咨询相关工单");
        workOrderClassBiz.createClass(woc);
        return Result.ok(woc);
    }

    //删除工单类别
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(List<Integer> ids){
        int a = workOrderClassBiz.deleteBatch(ids);
        return Result.ok(a);
    }
}
