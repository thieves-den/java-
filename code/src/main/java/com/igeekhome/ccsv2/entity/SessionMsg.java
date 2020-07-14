package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
public class SessionMsg {
    private int id;
    private int sessionId;
    private String msgSenderId;
    private String msgReceiverId;
    private String msgSenderName;
    private Session session;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime ;
}
