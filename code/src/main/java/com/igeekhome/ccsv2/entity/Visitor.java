package com.igeekhome.ccsv2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    private String id;
    private String ip;
    private String name;
    private String terninal;
    private String browser;
    private String screenSize;
    private String device;
    private String state;
    private Date createTime;
    private Date finishTime;
    private int visitDuration;
    private CustomerService customerService;
    private String firstMsg;
}
