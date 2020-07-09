package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICommonWordBiz;
import com.igeekhome.ccsv2.entity.CommonWord;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commonWord")
@ResponseBody
public class CommonWordController {
    @Autowired
    private ICommonWordBiz commonWordBiz;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(CommonWord commonWord,String content,boolean isPersonal,String type,int creatorId){
        commonWord.setContent(content);
        commonWord.setPersonal(isPersonal);
        commonWord.setType(type);
        return Result.ok(commonWordBiz.save(commonWord));
    }

}
