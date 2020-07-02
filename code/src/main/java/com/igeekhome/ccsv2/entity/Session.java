package com.igeekhome.ccsv2.entity;

import java.sql.Timestamp;

public class Session {
    private int customerServiceId;
    private int visitorIp;
    private String visitorName;
    private Timestamp createTime;
    private Timestamp finishTime;
    private String channel;
    private Timestamp evaluationTime;
    private String evaluation;
    private String evaluationDetail;
    private Timestamp firstRespondTime;
    private int customerMsgNum;
    private int customerServiceMsgNum;
}
