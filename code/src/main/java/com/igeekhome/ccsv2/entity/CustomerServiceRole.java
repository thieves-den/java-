package com.igeekhome.ccsv2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerServiceRole {
    private int id;
    private String roleDescribe;
    private String name;
    private int number;
    private int creatorId;
    private Date updateTime;
    private Date createTime;
}
