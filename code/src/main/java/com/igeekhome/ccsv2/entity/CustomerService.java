package com.igeekhome.ccsv2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerService {
    private String headImg;
    private String state;
    private String nickName;
    private String realName;
    private String customerServiceId;
    private String customerServicePhone;
    private String password;
    /**
     * 关联的客服组
     */
    private CustomerServiceGroup group;
    /**
     * 关联的客服角色
     */
    private CustomerServiceRole role;

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
