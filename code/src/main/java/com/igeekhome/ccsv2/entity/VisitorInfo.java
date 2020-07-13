package com.igeekhome.ccsv2.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Data
//包含客户与普通访客的来访信息,可以是一个用户多次访问
public class VisitorInfo {
    private String id; //访客UUID
    private String nickName;
    private int customerServiceId;  //受理客服的id
    private String customerId; //客户才拥有
    private String groupName;  //受理客服组
    private String customerServiceName; //受理客服昵称
    private String visitorName;
    private String ip;
    private String terminal;//终端
    private String browser;
    private String screenSize;
    private String device;
    private int state;
    private int satisfaction; //满意度打分
    private int visitNum;
    private int visitorNum;
    private double averageDuration;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date visitDuration;
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm", timezone = "GMT+8")
    private Date visitTime;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date endTime;
}
