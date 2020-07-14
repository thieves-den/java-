package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ISessionBiz;
import com.igeekhome.ccsv2.entity.Session;
import com.igeekhome.ccsv2.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionBizImpl implements ISessionBiz {

    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public List<Session> select(Session session) {
        return sessionMapper.select(session);
    }

    @Override
    public List<Session> getSessionList(Integer customerServiceId, Integer type, Integer pageNum) {
        return sessionMapper.getSessionList(customerServiceId,type,pageNum);
    }

    @Override
    public int save(Session cs_session) {
        return sessionMapper.save(cs_session);
    }

    @Override
    public void updateMsgCount(String sessionId, String type) {
        sessionMapper.updateMsgCount(sessionId,type);
    }

    @Override
    public void closeSessionBy(String userName,String type) {
        sessionMapper.closeSessionBy(userName,type);
    }
}
