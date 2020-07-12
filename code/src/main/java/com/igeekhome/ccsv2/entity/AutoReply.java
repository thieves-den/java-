package com.igeekhome.ccsv2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AutoReply {
     private int customerServiceId; //自动回复创建者的客服id
     private String terminal; //终端类型：web、app,mp,weibo,wap,h5
     private String welcome; //欢迎消息
     private int wState; //欢迎消息是否自动发送',
     private String customerServiceNoResponse; //'客服无应答自动回复消息'
     @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
     private Date customerServiceTimeLimit; //'客服无响应时间限制'
     private int cSNState; // '客服无应答消息是否自动发送'
     private String customerNoResponse; // '顾客无响应回复'
     @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
     private Date customerTimeLimit; // '顾客无响应时间限制'
     private int cNState; // '顾客无响应是否自动回复'
     private String customerServiceEnd; // '客服手动结束回复内容'
     private String systemEnd; // '系统自动结束回复内容'
     private int eState; //对话结束时是否自动回复
}
