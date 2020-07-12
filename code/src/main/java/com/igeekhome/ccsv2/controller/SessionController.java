package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ISessionBiz;
import com.igeekhome.ccsv2.entity.Session;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private ISessionBiz sessionBiz;

    @GetMapping("/select")
    public @ResponseBody
    Result select(Session session){
        List<Session> se = sessionBiz.select(session);
        return Result.ok(se);
    }

}
