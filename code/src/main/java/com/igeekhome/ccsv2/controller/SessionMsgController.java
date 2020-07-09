package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ISessionMsgBiz;
import com.igeekhome.ccsv2.entity.SessionMsg;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("smsg")
public class SessionMsgController {
    @Autowired
    private ISessionMsgBiz sessionMsgBiz;
    @RequestMapping(value = {"/create"},method = RequestMethod.POST)
    public @ResponseBody Result create(SessionMsg sessionMsg){
        HashMap<String,Integer> tem = sessionMsgBiz.findId();
        int s = tem.get("MAX(session_id)") + 1;
        sessionMsg.setSessionId(s);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp time = Timestamp.valueOf(dateFormat.format(date));
        sessionMsg.setSendTime(time);
        int a = sessionMsgBiz.create(sessionMsg);
        return Result.ok(a);
    }
}
