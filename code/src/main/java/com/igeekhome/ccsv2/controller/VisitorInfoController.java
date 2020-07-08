package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.IVisitorInfoBiz;
import com.igeekhome.ccsv2.entity.VisitorInfo;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/vistor")
public class VisitorInfoController {
    @Autowired
    private IVisitorInfoBiz visitorInfoBiz;

    @RequestMapping(value ={"/select"},method = RequestMethod.GET)
    public @ResponseBody
    List<VisitorInfo> select(VisitorInfo visitorInfo){
        List<VisitorInfo> visitor = visitorInfoBiz.select(visitorInfo);
        return visitor;
    }
}
