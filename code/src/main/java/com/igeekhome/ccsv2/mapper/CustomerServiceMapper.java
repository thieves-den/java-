package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerService;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface CustomerServiceMapper {
    int update(CustomerService service);

    int updatePwd(CustomerService service);

    HashMap<String, String> findPwd(CustomerService service);
}
