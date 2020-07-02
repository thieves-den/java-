package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.SessionMsg;

import java.util.HashMap;

public interface ISessionMsgBiz {
    HashMap<String, Integer> findId();

    int create(SessionMsg sessionMsg);
}
