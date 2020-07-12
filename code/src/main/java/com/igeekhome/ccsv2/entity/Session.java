package com.igeekhome.ccsv2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@Data
public class Session {
    private int customerServiceId;
    private String visitorIp;
    private String visitorName;
    @JsonFormat(pattern = "HH:mm")
    private Date creatTime;
    private Timestamp finishTime;
    private String channel;
    private Timestamp evaluationTime;
    private String evaluation;
    private String evaluationDetail;
    private Timestamp firstRespondTime;
    private int customerMsgNum;
    private int customerServiceMsgNum;
}
