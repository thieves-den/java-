package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.INoticeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private INoticeBiz noticeBiz;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public int save(String title,String content,int creatorId){
        return noticeBiz.save(title,content,creatorId);
    }

}
