package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class WorkOrder {
    private int workOrderId;
    private String type;
    private String title;
    private String orderDesc;
    private String attachments;
    private String cclist;
    private String priority;
    private String state;
    private String groupName;//客服组名
    private String customerServiceName;//客服真实姓名
    private int customerServiceId;
    private int customerId;
    private String customerRealName;//顾客真实姓名
    private String channel;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
