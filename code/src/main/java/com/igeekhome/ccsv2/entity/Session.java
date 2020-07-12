package com.igeekhome.ccsv2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@Data
public class Session {
    private  int sessionId;

    private int customerServiceId;
    private String visitorIp;
    private String visitorName;
    private String channel;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "HH:mm")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstRespondTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date evaluationTime;
    private String evaluation;
    private String evaluationDetail;

    private int customerMsgNum;
    private int customerServiceMsgNum;

    private String content;//最后更新的消息
}
