package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ISessionMsgBiz;
import com.igeekhome.ccsv2.entity.SessionMsg;
import com.igeekhome.ccsv2.mapper.SessionMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SessionMsgBizImpl implements ISessionMsgBiz {
    @Autowired
    private SessionMsgMapper sessionMsgMapper;
    @Override
    public HashMap<String, Integer> findId() {
        return sessionMsgMapper.findId();
    }

    @Override
    public int create(SessionMsg sessionMsg) {
        return sessionMsgMapper.create(sessionMsg);
    }
}
