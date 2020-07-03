package com.igeekhome.ccsv2.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CustomerServiceRole {
    private int id;
    private String roleDescribe;
    private String name;
    private int number;
    private int creatorId;
    private Timestamp updateTime;
    private Timestamp createTime;
}
