package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface CustomerInfoMapper {
    int create(CustomerInfo customerInfo);
    HashMap<String, Integer> createId();

    //客户信息表搜索
    List<CustomerInfo> select(CustomerInfo customerInfo);
    //根据创建日期搜索客户信息

    int delete(CustomerInfo customerInfo);

    List<CustomerInfo> selectByDate(CustomerInfo customerInfo);
}
