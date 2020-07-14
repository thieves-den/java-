package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.SessionMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface SessionMsgMapper {
    HashMap<String, Integer> findId();

    int create(SessionMsg sessionMsg);

    @Insert("insert into session_msg(msg_sender_Id,msg_receiver_id,content,session_id,create_time) values(#{msgSenderId},#{msgReceiverId},#{content},#{session.id},#{createTime})")
    void insert(SessionMsg sessionMsg);
}
