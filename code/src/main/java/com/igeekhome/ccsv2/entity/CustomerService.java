package com.igeekhome.ccsv2.entity;
import java.sql.Time;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class CustomerService {
    private int id;
    private String phone;
    private String password;
    private int onlineState;
    private int workState;
    private String headImg;
    private String email;
    private String nickName;
    private String realName;
    //关联的客服组
    CustomerServiceGroup group;
    //关联的客服角色
    CustomerServiceRole role;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Time totalOnlineTime;
    private Timestamp onlineTimeBegin;
    private Timestamp onlineTimeEnd;
    private int sessionCount;
    private int msgCount;
    private int serviceCap;

}
