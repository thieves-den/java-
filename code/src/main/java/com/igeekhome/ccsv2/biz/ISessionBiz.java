package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.Session;

import java.util.List;

public interface ISessionBiz {
    List<Session> select(Session session);

    List<Session> getSessionList(Integer customerServiceId, Integer type, Integer pageNum);

    int save(Session cs_session);

    void updateMsgCount(String sessionId, String type);

    void closeSessionBy(String userName,String type);
}
