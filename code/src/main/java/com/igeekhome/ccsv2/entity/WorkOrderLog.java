package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkOrderLog {
    private int customerServiceId;
    private int wordOrderId;
    private String content;
}
