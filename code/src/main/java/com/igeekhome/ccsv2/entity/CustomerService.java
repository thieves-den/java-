package com.igeekhome.ccsv2.entity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CustomerService {
    private int id;
    private int customerServiceId;
    private String phone;
    private String password;
    private Integer onlineState;
    private Integer workState;
    private Byte[] headImg;
    private String email;
    private String nickName;
    private String realName;
    //关联的客服组
    CustomerServiceGroup group;
    //关联的客服角色
    CustomerServiceRole role;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date totalOnlineTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date averageResponseTime;//平均响应时长
    @JsonFormat(pattern = "HH:mm:ss")
    private Date averageSessionTime;//平均会话时长

    private Date createTime;
    private Date updateTime;
    private Date onlineTimeBegin;
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
