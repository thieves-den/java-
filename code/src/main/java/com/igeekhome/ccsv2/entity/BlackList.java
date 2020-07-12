package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class BlackList {
    private int customerServiceId;
    private int customerId;
    private String reason;
    private String source;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
