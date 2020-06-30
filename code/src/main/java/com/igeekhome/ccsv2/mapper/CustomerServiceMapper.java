package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerServiceMapper {
    int update(CustomerService service);
}
