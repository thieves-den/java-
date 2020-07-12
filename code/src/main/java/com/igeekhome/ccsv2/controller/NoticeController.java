package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.INoticeBiz;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/notice")
@ResponseBody
public class NoticeController {
    @Autowired
    private INoticeBiz noticeBiz;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(String title,String content,int creatorId){
        Date date = new Date();
        //date = dateformat.parse("2020-7-6 12:09:36"); ——>Date赋值语句
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp time = Timestamp.valueOf(dateFormat.format(date));//获取当前时间
        return Result.ok(noticeBiz.save(title,content,creatorId,time));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(String title,String content){
        return Result.ok(noticeBiz.delete(title,content));
    }

}
