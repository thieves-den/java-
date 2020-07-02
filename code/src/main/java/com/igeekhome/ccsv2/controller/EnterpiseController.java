package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ICustomerServiceGroupBiz;
import com.igeekhome.ccsv2.biz.IEnterpiseBiz;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.entity.Enterpise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/enterpise")
public class EnterpiseController {

    @Autowired
    private IEnterpiseBiz enterpiseBiz;
    /**
     * 对外提供保存创建客服组的服务
     */
    @RequestMapping(value = {"/update"},method = RequestMethod.POST)
    public @ResponseBody
    String update(Enterpise enterpise){
        int a = enterpiseBiz.update(enterpise);
        return a+"";
    }

}
