package com.igeekhome.ccsv2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class Tags {
    private int id;
    private String name;
    private int creatorId;
    private int numOfUse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


}
