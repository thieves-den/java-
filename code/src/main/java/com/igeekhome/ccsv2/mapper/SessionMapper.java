package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.Session;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SessionMapper {
    List<Session> select(Session session);
}