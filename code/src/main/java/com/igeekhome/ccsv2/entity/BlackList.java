package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlackList {
    private int customerServiceId;
    private int customerId;
    private String reason;
}
