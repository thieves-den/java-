package com.project.ccs.entity;

import lombok.Data;

import javax.xml.ws.Service;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class CustomerService {
    private String phone;
    private String password;
    private int state;
    private String headImg;
    private String email;
    private String niceName;
    private String realname;
    private int customerServiceId;
    private String customerServicePhone;
    private Timestamp totalOnlineTime;
    private Timestamp onlineTimeBegin;
    private Timestamp onlineTimeEnd;
    private int sessionCount;
    private int msgCount;
    private int customerServiceGroupId;
    private String role;
    private int serviceCap;
}
