package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerService;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface CustomerServiceMapper {

    /**
     * 根据id查询，返回单一查询对象
     */
    CustomerService queryById(int id);

    int update(CustomerService cs);

    int updatePwd(CustomerService cs);

    HashMap<String, String> findPwd(CustomerService cs);


    int resign(CustomerService customerService);
}
