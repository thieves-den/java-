package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.AutoReply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AutoReplyMapper {

    AutoReply showSetting(int customerServiceId);//客服登陆打开此页面就会显示，之前的自动回复设置情况

    int saveWelcome(AutoReply autoReply);//欢迎消息
    int saveCSNResponse(AutoReply autoReply);//保存客服无应答自动回复消息
    int saveCNResponse(AutoReply autoReply);//保存顾客无应答自动回复消息
    int saveEnd(AutoReply autoReply);//对话结束时
}
