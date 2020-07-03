package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CommonWord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonWordMapper {
    int save(CommonWord commonWord);
}
