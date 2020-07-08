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
//    DateTimeFormat用来对入参进行解析用的
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private List<CustomerService> groupCustomerService;
}
