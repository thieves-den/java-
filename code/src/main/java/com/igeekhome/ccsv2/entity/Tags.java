package com.igeekhome.ccsv2.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Tags {
    private int id;
    private String name;
    private int creatorId;
    private int numOfUse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


}
