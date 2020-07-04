package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.BlackList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlackListMapper {
    int delete(BlackList blackList);

    int create(BlackList blackList);
}
