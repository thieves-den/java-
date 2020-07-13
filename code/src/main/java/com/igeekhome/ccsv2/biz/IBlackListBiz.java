package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.BlackList;
import com.igeekhome.ccsv2.entity.CustomerInfo;

import java.util.List;

public interface IBlackListBiz {
    int delete(BlackList blackList);

    int create(BlackList blackList);

    List<BlackList> showBlackRecord(CustomerInfo customerInfo);
}
