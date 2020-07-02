package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.Enterpise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpiseMapper {
    int update(Enterpise enterpise);
}
