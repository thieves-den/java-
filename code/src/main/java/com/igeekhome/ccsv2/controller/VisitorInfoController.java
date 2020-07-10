package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IVisitorInfoBiz;
import com.igeekhome.ccsv2.entity.VisitorInfo;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
