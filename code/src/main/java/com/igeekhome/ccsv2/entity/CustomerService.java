package com.igeekhome.ccsv2.entity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CustomerService {
    private int id;
    private int customerServiceId;
    private String phone;
    private String password;
    private String onlineState;//在线或离线
    private Integer workState;
    private Byte[] headImg;
    private String email;
    private String nickName;
    private String realName;
    private int finishedSession;
    private double totalTime;
    private  int busyTime;
    private int roleId;
    private int customerServiceGroupId;
    //关联的客服组
    CustomerServiceGroup group;
    //关联的客服角色
    CustomerServiceRole role;
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    private Date totalOnlineTime;//总计在线时长
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    private Date averageResponseTime;//平均响应时长
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    private Date averageSessionTime;//平均会话时长
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date onlineTimeBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date onlineTimeEnd;

    private Integer sessionCount;//会话次数
    private Integer msgCount;
    private Integer serviceCap;

    //重写equals方法，用于判断两个CustomerService对象是否相同
    @Override
    public boolean equals(Object obj) {
        CustomerService cs = (CustomerService) obj;
        return this.phone.equals(cs.phone) && this.id == cs.id;
    }

}
