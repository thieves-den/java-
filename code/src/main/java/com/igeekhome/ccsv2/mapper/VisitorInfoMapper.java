package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.VisitorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisitorInfoMapper {
    List<VisitorInfo> select(VisitorInfo visitorInfo);
}
