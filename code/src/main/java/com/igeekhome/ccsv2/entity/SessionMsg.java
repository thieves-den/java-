package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class SessionMsg {
    private int sessionId;
    private int msgSenderId;
    private int msgReceiverId;
    private Timestamp sendTime;
    private String centent;
}
