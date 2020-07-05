package com.igeekhome.ccsv2.entity;
import java.sql.Time;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class CustomerService {
    private int id;
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
    private Timestamp createTime;
    private Timestamp updateTime;
    private Time totalOnlineTime;
    private Timestamp onlineTimeBegin;
    private Timestamp onlineTimeEnd;
    private Integer sessionCount;
    private Integer msgCount;
    private Integer serviceCap;


    //重写equals方法，用于判断两个CustomerService对象是否相同
    @Override
    public boolean equals(Object obj) {
        CustomerService cs = (CustomerService) obj;
        return this.phone.equals(cs.phone) && this.id == cs.id;
    }

}
