package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICommonWordBiz;
import com.igeekhome.ccsv2.biz.ICommonWordTypeBiz;
import com.igeekhome.ccsv2.entity.CommonWord;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commonWordType")
@ResponseBody
public class CommonWordTypeController {
    @Autowired
    private ICommonWordTypeBiz commonWordTypeBiz;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(String name, boolean isPersonal,int creatorId){
        return Result.ok(commonWordTypeBiz.save(name,isPersonal,creatorId));
    }
}
