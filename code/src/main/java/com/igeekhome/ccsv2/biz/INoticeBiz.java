package com.igeekhome.ccsv2.biz;

import java.util.Date;

public interface INoticeBiz {
    int save(String title, String content, int creatorId, Date createTime);
    int delete(String title,String content);
}
