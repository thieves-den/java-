package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.ISessionBiz;
import com.igeekhome.ccsv2.entity.Session;
import com.igeekhome.ccsv2.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据某客服的customerServiceId！查询当前会话列表或历史会话列表信息,type=1表示历史会话，type=0表示当前正在进行的会话
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Result getSessionList(@RequestParam(required = true)Integer customerServiceId,
                                 @RequestParam(required = false,defaultValue = "1")Integer type,
                                 @RequestParam(required = false,defaultValue = "1")Integer pageNum){

        List<Session> sessions = sessionBiz.getSessionList(customerServiceId,type,pageNum);
        return Result.ok(sessions);

    }

}
