package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.VisitorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VisitorInfoMapper {
    List<VisitorInfo> select(VisitorInfo visitorInfo);

    List<VisitorInfo> queryVisit(VisitorInfo visitorInfo);

    void insert(VisitorInfo visitor);

    @Select("select ip,name from visitor_info where id = #{id}")
    VisitorInfo getOneById(String id);
}
