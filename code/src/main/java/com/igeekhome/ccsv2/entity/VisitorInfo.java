package com.igeekhome.ccsv2.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class VisitorInfo {
    private int customerServiceId;
    private String nickName;
    private String visitorName;
    private String ip;
    private String terminal;
    private String browser;
    private String screenSize;
    private String device;
    private int state;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date visitDuration;
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm", timezone = "GMT+8")
    private Date visitTime;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date endTime;
}
