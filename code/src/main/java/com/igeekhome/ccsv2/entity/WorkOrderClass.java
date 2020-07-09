package com.igeekhome.ccsv2.entity;

import lombok.Data;
import java.util.Date;

@Data
public class WorkOrderClass {
    private int id;
    private String className;
    private int number;
    private Date createTime;
}
