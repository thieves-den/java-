package com.igeekhome.ccsv2.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface NoticeMapper {
    int save(String title, String content, int creatorId, Date createTime);
    int delete(String title,String content);

}
