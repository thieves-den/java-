package com.igeekhome.ccsv2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CustomerInfo {
    private int customerId;
    private int customerServiceId;
    private String nickName;
    private String realName;
    private String phone;
    private String email;
    private String company;
    private String address;
    private String level;
    private String channel;
    private String remark;
    private String tags;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastedLoginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    public void setcustomerId(int v) {
        this.customerId = v;
    }
}
