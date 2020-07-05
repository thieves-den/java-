package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.Tags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagsMapper {
    int save(Tags tags);

    int delete(int id);

    int update(String name,int id);
}
