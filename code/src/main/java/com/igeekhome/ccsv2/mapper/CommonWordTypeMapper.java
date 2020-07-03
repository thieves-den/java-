package com.igeekhome.ccsv2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonWordTypeMapper {
    int save(String name,boolean isPersonal,int creatorId);
}
