package com.igeekhome.ccsv2.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.igeekhome.ccsv2.biz.ISessionBiz;
import com.igeekhome.ccsv2.biz.ISessionMsgBiz;
import com.igeekhome.ccsv2.biz.VisitorBiz;
import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.SessionMsg;
import com.igeekhome.ccsv2.entity.Visitor;
import com.igeekhome.ccsv2.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/webSocket/{sid}/{type}")
@Component
public class WebSocketServer {
    private ISessionBiz sessionBiz;
    private ISessionMsgBiz sessionMsgBiz;
    private VisitorBiz visitorBiz;

    public WebSocketServer(){
//        因为ServerEndpoit注解的元素是多例，每有一个客服端来open，就会创建一个实例，AutoWire注解失效
        this.sessionBiz = SpringContextUtils.getBean(ISessionBiz.class);
        this.sessionMsgBiz = SpringContextUtils.getBean(ISessionMsgBiz.class);
        this.visitorBiz = SpringContextUtils.getBean(VisitorBiz.class);
    }
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static ConcurrentHashMap<String, JSONObject> cs_sessionPools = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Session> visitor_sessionPools = new ConcurrentHashMap<>();

    //发送消息
    public void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
//                System.out.println("发送数据：" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }
    //给指定用户发送信息
    public void sendInfo(String message) throws IOException {
        JSONObject obj = JSON.parseObject(message);
        String type = obj.getString("type");
        String content = obj.getString("content");
        String createTime = obj.getString("createTime");
        String msgSenderId = obj.getString("msgSenderId");
        String sessionId = obj.getString("sessionId");
        String msgReceiverId = obj.getString("msgReceiverId");

//        保存会话消息
        SessionMsg sessionMsg =  obj.toJavaObject(SessionMsg.class);
        sessionMsg.getSession().setId(Integer.parseInt(sessionId));
        sessionMsgBiz.save(sessionMsg);
//更新会话消息数量
        sessionBiz.updateMsgCount(sessionId,type);
//        将会话消息保存到数据库

        Session session = null;
        if("visitor".equals(type)){
            session = cs_sessionPools.get(msgReceiverId).getObject("session",Session.class);
        }else if("cs".equals(type)){
            session = visitor_sessionPools.get(msgReceiverId);
        }

        try {
            sendMessage(session, message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //建立连接成功调用
    //当访客第一次连接的时候，返回给访客他的客服id，会话id,欢迎信息
//    给客服更新当前会话列表
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sid") String userName,@PathParam(value="type") String type){
        //当访客连接websocket的时候，应该按照业务配置返回默认的自动响应消息
        addOnlineCount();
        System.out.println(userName + "加入webSocket！当前人数为" + onlineNum);
        try {
            if("visitor".equals(type)){
                visitor_sessionPools.put(userName,session);
//                要分配在线客服，并以客服的身份自动回复一条消息
                int tempCsId = 1;
                JSONObject cs =  cs_sessionPools.get(tempCsId+"");
                cs.put("count",cs.getInteger("count")+1);
//                为这个客服和访客创建一次会话
                com.igeekhome.ccsv2.entity.Session cs_session = new com.igeekhome.ccsv2.entity.Session();
                cs_session.setVisitorId(userName);
                cs_session.setCustomerServiceId(1);
                String content = "你好，请问有什么可以帮助你的";
                cs_session.setContent(content);
                Visitor visitor = visitorBiz.getOneById(userName);
                cs_session.setVisitorIp(visitor.getIp());
                cs_session.setVisitorName(visitor.getName());
                CustomerService customerService = new CustomerService();
                customerService.setId(tempCsId);
                cs_session.setCs(customerService);
                cs_session.setCustomerServiceId(1);
                System.out.println(cs_session);
//                创建会话信息
                sessionBiz.save(cs_session);
                int sessionId =  cs_session.getId();//得到会话的id
//                给访客自动回消息:包括消息内容，客服，回复时间
                JSONObject respMsg = new JSONObject();
                respMsg.put("content",content);
                respMsg.put("time", LocalDateTime.now().toString());
                respMsg.put("csId",tempCsId);// 分配给这个访客的客服id
                respMsg.put("sessionId",sessionId);//本次会话的id
                sendMessage(session, JSON.toJSONString(respMsg));//把这个消息发送给访客
//                更新客服的会话列表
                List<com.igeekhome.ccsv2.entity.Session> sessionList = sessionBiz.getSessionList(tempCsId,0,1);
                JSONObject respMsg2 = new JSONObject();
                respMsg2.put("sessionList",sessionList);
                respMsg2.put("type","new-session");
                sendMessage(cs.getObject("session",Session.class),JSON.toJSONStringWithDateFormat(respMsg2,"yyyy-MM-dd HH:mm:ss"));
            }else {
//                当客服上线后，初始化服务的客户数为0，
                JSONObject obj = new JSONObject();
                obj.put("count",0);
                obj.put("session",session);
                cs_sessionPools.put(userName, obj);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭连接时调用
    @OnClose
    public void onClose(CloseReason reason,@PathParam(value = "sid") String userName,@PathParam(value="type") String type){
        if("cs".equals(type)){
            cs_sessionPools.remove(userName);
        }else {
            visitor_sessionPools.remove(userName);
        }
        sessionBiz.closeSessionBy(userName,type);
        subOnlineCount();
        System.out.println(userName + "断开webSocket连接！当前人数为" + onlineNum);
    }

    //收到客户端信息,转发给消息接受者
    @OnMessage
    public void onMessage(String message,@PathParam(value="type") String type) throws IOException{
        JSONObject obj = JSON.parseObject(message);
        String content = obj.getString("content");
        String msgSenderId = obj.getString("msgSenderId");
        int sessionId = obj.getInteger("sessionId");
        String msgReceiverId = obj.getString("msgReceiverId");

//        保存会话消息
        SessionMsg sessionMsg =  obj.toJavaObject(SessionMsg.class);
        com.igeekhome.ccsv2.entity.Session ycs_session = new com.igeekhome.ccsv2.entity.Session();
        ycs_session.setId(sessionId);
        sessionMsg.setSession(ycs_session);
        sessionMsgBiz.save(sessionMsg);
//更新会话消息数量
        sessionBiz.updateMsgCount(sessionId+"",type);
//        将会话消息保存到数据库
        //将消息转发给消息的接受者
        Session session = null;
        if("visitor".equals(type)){
            session = cs_sessionPools.get(msgReceiverId).getObject("session",Session.class);
        }else if("cs".equals(type)){
            session = visitor_sessionPools.get(msgReceiverId);
        }

        try {
            sendMessage(session, message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }

}
