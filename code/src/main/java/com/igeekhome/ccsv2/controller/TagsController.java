package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceGroupBiz;
import com.igeekhome.ccsv2.biz.ITagsBiz;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.entity.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    private ITagsBiz tagsBiz;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public int save(Tags tags){
        int a=tagsBiz.save(tags);
        return a;
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public int delete(int id){
        int a=tagsBiz.delete(id);
        return a;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public int update(String name,int id){
        int a=tagsBiz.update(name,id);
        return a;
    }
}
