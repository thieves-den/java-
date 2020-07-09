package com.igeekhome.ccsv2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class CustomerServiceGroup {
    private  int id;
    private String name;
    private int number;
    private Date createTime;
    private Date updateTime;
    private List<CustomerService> groupCustomerService;
}
