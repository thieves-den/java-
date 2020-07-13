package com.igeekhome.ccsv2.controller;


import com.igeekhome.ccsv2.biz.IEnterpiseBiz;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.entity.Enterpise;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/enterpise")
@CrossOrigin
public class EnterpiseController {

    @Autowired
    private IEnterpiseBiz enterpiseBiz;
    /**
     * 对外提供保存创建企业的服务
     */
    @RequestMapping(value = {"/update"},method = RequestMethod.POST)
    public @ResponseBody
    Result update(@RequestBody Enterpise enterpise){
        int a = enterpiseBiz.update(enterpise);
        return Result.ok(a);
    }

}
