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

    //查询工单类别
    @GetMapping(value = "/query")
    @ResponseBody
    public Result queryByName(WorkOrderClass cs){
        cs.setClassName("推广");
        List<WorkOrderClass> wocList = workOrderClassBiz.queryByName(cs);
        return Result.ok(wocList);
    }
}
