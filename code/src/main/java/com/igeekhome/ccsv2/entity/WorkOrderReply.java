package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Setter
@Getter
public class WorkOrderReply {
    private int workOrderId;
    private int customerServiceId;
    private Timestamp reply;
    private String content;
}
