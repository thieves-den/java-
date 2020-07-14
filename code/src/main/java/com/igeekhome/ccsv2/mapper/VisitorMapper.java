package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.Visitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VisitorMapper {
    @Insert("insert into visitor_info(id,ip,name,terninal,browser,screen_size,device) " +
            "values(#{id},#{ip},#{name},#{terninal},#{browser},#{screenSize},#{device})")
    void insert(Visitor visitor);

    @Select("select ip,name from visitor_info where id = #{id}")
    Visitor getOneById(String id);
}
