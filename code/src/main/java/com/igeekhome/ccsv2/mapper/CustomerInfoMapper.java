package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface CustomerInfoMapper {
    int create(CustomerInfo customerInfo);

    HashMap<String, Integer> createId();
}
