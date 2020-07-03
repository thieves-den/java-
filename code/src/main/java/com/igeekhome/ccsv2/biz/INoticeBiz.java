package com.igeekhome.ccsv2.biz;

public interface INoticeBiz {
    int save(String title,String content,int creatorId);
    int delete(String title,String content);
}
