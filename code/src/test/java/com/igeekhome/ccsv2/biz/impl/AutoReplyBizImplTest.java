package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.entity.AutoReply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AutoReplyBizImplTest {
    @Autowired AutoReplyBizImpl autoReplyBiz;

    @Test
    void saveWelcome() {
        AutoReply autoReply = new AutoReply();
        autoReply.setWState(1);
        autoReply.setWelcome("hello！欢迎咨询客服云~");
        autoReply.setCustomerServiceId(15);
        int a = autoReplyBiz.saveWelcome(autoReply);
        System.out.println(a);
    }

    @Test
    void saveCSNResponse() throws ParseException {
        AutoReply autoReply = new AutoReply();
        autoReply.setCustomerServiceId(15);
        autoReply.setCSNState(1);
        autoReply.setCustomerServiceNoResponse("客服姐姐马上回来哦，麻烦客官稍等一下哦~");
        Date t = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
        t = dateformat.parse("08:00:20");
        autoReply.setCustomerServiceTimeLimit(t);
        int a = autoReplyBiz.saveCSNResponse(autoReply);
        System.out.println(a);
    }

    @Test
    void saveCNResponse() throws ParseException {
        AutoReply autoReply = new AutoReply();
        autoReply.setCNState(1);
        autoReply.setCustomerServiceId(15);
        Date t = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
        t = dateformat.parse("08:00:20");
        autoReply.setCustomerTimeLimit(t);
        autoReply.setCustomerNoResponse("您好客官！请问还有什么能够帮助到您吗？");
        int a = autoReplyBiz.saveCNResponse(autoReply);
        System.out.println(a);
    }

    @Test
    void saveEnd() {
        AutoReply autoReply = new AutoReply();
        autoReply.setEState(1);
        autoReply.setCustomerServiceId(15);
        autoReply.setCustomerServiceEnd("客服已为您关闭对话，请对本次服务做出评价~");
        autoReply.setSystemEnd("由于您长时间没有说话，系统已为您关闭对话，欢迎对本次服务做出评价~");
        int a = autoReplyBiz.saveEnd(autoReply);
        System.out.println(a);
    }
}