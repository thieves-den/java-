package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IWorkOrderBiz;
import com.igeekhome.ccsv2.entity.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/workorder")
public class WorkOrderController {
    @Autowired
    private IWorkOrderBiz workOrderBiz;

    @RequestMapping(value = {"/create"},method = RequestMethod.POST)
    public @ResponseBody String create(WorkOrder workOrder){
        HashMap<String, Integer> tem = workOrderBiz.findId();
        int s = tem.get("MAX(work_order_id)") + 1;
        workOrder.setWorkOrderId(s);
        if(workOrder.getType() == null||workOrder.getTitle()==null||workOrder.getOrderDesc() == null)
            return "请填写完整";
        int a = workOrderBiz.create(workOrder);
            return a + "";
    }
}
