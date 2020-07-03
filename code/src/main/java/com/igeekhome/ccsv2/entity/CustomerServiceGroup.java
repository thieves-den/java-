package com.igeekhome.ccsv2.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class CustomerServiceGroup {
    private  int id;
    private String groupName;
    private int number;
    //    DateTimeFormat用来对入参进行解析用的
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Date updateTime;
}
