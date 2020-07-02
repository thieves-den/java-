package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.SessionMsg;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface SessionMsgMapper {
    HashMap<String, Integer> findId();

    int create(SessionMsg sessionMsg);
}
