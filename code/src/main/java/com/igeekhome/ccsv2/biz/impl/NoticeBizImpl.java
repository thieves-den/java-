package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoticeBizImpl implements com.igeekhome.ccsv2.biz.INoticeBiz{
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public int save(String title, String content, int creatorId, Date createTime) {
        return noticeMapper.save(title,content,creatorId,createTime);
    }

    @Override
    public int delete(String title, String content) {
        return noticeMapper.delete(title,content);
    }
}
