package com.igeekhome.ccsv2.controller;

import com.igeekhome.ccsv2.biz.VisitorBiz;
import com.igeekhome.ccsv2.entity.Visitor;
import com.igeekhome.ccsv2.utils.Result;
import com.igeekhome.ccsv2.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/visitor")
@CrossOrigin
public class VisitorController {
    @Autowired
    private VisitorBiz visitorBiz;

    @GetMapping("/currentSession")
    public List<Visitor> current_session_user(Integer customerServiceId){
        List<Visitor> visitors = new ArrayList<>();



        return visitors;
    }

    @GetMapping("/id")
    public String getId(){
        return SpringContextUtils.getDomain();
    }

    @PostMapping("/save")
    public Result<Object> save(@RequestBody Visitor visitor){
        String id = UUID.randomUUID().toString();

        visitor.setId(id);
        visitorBiz.save(visitor);

        return Result.ok(id);
    }
}
