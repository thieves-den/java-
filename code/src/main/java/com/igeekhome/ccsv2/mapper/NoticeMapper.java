package com.igeekhome.ccsv2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
    int save(String title,String content,int creatorId);

}
