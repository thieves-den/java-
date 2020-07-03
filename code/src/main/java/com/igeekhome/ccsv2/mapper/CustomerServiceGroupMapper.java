package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerServiceGroupMapper {
    int save(CustomerServiceGroup group);

    CustomerServiceGroup getOne(String name);
    int delete(int id);
}
