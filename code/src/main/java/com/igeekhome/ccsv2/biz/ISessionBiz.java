package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.Session;

import java.util.List;

public interface ISessionBiz {
    List<Session> select(Session session);
}
