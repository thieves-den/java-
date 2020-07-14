package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IWorkOrderClassBiz;
import com.igeekhome.ccsv2.entity.WorkOrderClass;
import com.igeekhome.ccsv2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date date = new Date();
        //date = dateformat.parse("2020-7-6 12:09:36"); ——>Date赋值语句
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp time = Timestamp.valueOf(dateFormat.format(date));//获取当前时间
        woc.setCreateTime(time);
        int a = workOrderClassBiz.createClass(woc);
        return Result.ok(a);
    }

    //删除工单类别
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(List<Integer> ids){
        int a = workOrderClassBiz.deleteBatch(ids);
        return Result.ok(a);
    }
}
