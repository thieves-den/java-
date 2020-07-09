package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.INoticeBiz;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notice")
@ResponseBody
public class NoticeController {
    @Autowired
    private INoticeBiz noticeBiz;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(String title,String content,int creatorId){
        return Result.ok(noticeBiz.save(title,content,creatorId));
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(String title,String content){
        return Result.ok(noticeBiz.delete(title,content));
    }

}
