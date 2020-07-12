package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IWorkOrderBiz;
import com.igeekhome.ccsv2.entity.WorkOrder;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/workorder")
@CrossOrigin
public class WorkOrderController {
    @Autowired
    private IWorkOrderBiz workOrderBiz;

    @RequestMapping(value = {"/create"},method = RequestMethod.POST)
    public @ResponseBody
    Result create(@RequestBody  WorkOrder workOrder){
        HashMap<String, Integer> tem = workOrderBiz.findId();
        int s = tem.get("MAX(work_order_id)") + 1;
        workOrder.setWorkOrderId(s);
        if(workOrder.getType() == null||workOrder.getTitle()==null||workOrder.getOrderDesc() == null)
            return Result.error("请填写完整");
        int a = workOrderBiz.create(workOrder);
            return Result.ok(a);
    }

    @RequestMapping(value = {"/select"},method = RequestMethod.GET)
    public @ResponseBody
    Result select(WorkOrder workOrder) {
        List<WorkOrder> workOrders = workOrderBiz.select(workOrder);
        return Result.ok(workOrders);
    }

    @RequestMapping(value = {"/selectByDate"},method = RequestMethod.GET)
    public @ResponseBody
    Result selectByDate(Date beginTime,Date endTime) {
        List<WorkOrder> workOrders = workOrderBiz.selectByDate(beginTime, endTime);
        return Result.ok(workOrders);
    }
}
