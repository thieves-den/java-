package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.entity.VisitorInfo;
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
    List<CustomerInfo> selectByDate(@Param("beginTime") Date begin, @Param("endTime") Date end);


    //客户详情中历史会话表（客户的访问信息）
    List<VisitorInfo> selectCustomerSession(CustomerInfo customerInfo);

    //根据customerId定位编辑修改客户信息
    int update(CustomerInfo customerInfo);

    int delete(CustomerInfo customerInfo);


}
