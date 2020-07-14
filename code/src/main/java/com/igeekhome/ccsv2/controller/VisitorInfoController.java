package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IVisitorInfoBiz;
import com.igeekhome.ccsv2.entity.VisitorInfo;
import com.igeekhome.ccsv2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/visitor")

public class VisitorInfoController {
    @Autowired
    private IVisitorInfoBiz visitorInfoBiz;

    //访客信息表
    @GetMapping("/select")
    public @ResponseBody
    Result select(VisitorInfo visitorInfo){
        if(null != visitorInfo.getVisitorName())
        {
            String tem = visitorInfo.getVisitorName();
            tem = "%" + tem + "%";
            visitorInfo.setVisitorName(tem);
        }
        List<VisitorInfo> visitor = visitorInfoBiz.select(visitorInfo);
        return Result.ok(visitor);
    }
    //访问统计表
    @GetMapping("/visit")
    @ResponseBody
    public Result CustomerServiceWorkload(VisitorInfo visitorInfo){
        List<VisitorInfo> visitor = visitorInfoBiz.queryVisit(visitorInfo);
        return Result.ok(visitor);
    }

    @PostMapping("/saveall")
    public Result<Object> save(@RequestBody VisitorInfo visitor){
        String id = UUID.randomUUID().toString();

        visitor.setId(id);
        visitorInfoBiz.save(visitor);

        return Result.ok(id);
    }
}
