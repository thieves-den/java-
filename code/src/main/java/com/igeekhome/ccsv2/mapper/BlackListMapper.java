package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.BlackList;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlackListMapper {
    int delete(BlackList blackList);

    int create(BlackList blackList);

    List<BlackList> showBlackRecord(CustomerInfo customerInfo);
}
