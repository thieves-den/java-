package com.igeekhome.ccsv2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerService {
    private int id;
    /**
    * 客服头像
    */
    private String headImg;
    private String state;
    private String nickName;
    private String email;
    private String realName;
    private String customerServiceId;
    private String customerServicePhone;
    private String password;
    private int serviceCap;
    private long totalOnlineTime;
    private Date onlineTimeBegin;
    private Date onlineTimeEnd;
    private int sessionCount;
    private int msgCount;
    private Date createTime;
    private Date updateTime;
    private int onLineState;
    private int workState;

}
