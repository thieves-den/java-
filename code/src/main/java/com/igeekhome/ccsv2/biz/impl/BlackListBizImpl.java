package com.igeekhome.ccsv2.biz.impl;


import com.igeekhome.ccsv2.biz.IBlackListBiz;
import com.igeekhome.ccsv2.entity.BlackList;
import com.igeekhome.ccsv2.entity.CustomerInfo;
import com.igeekhome.ccsv2.mapper.BlackListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListBizImpl implements IBlackListBiz {

    @Autowired
    private BlackListMapper blackListMapper;

    @Override
    public int delete(BlackList blackList) {
        return blackListMapper.delete(blackList);
    }

    @Override
    public int create(BlackList blackList) {
        return blackListMapper.create(blackList);
    }

    @Override
    public List<BlackList> showBlackRecord(CustomerInfo customerInfo) {
        return blackListMapper.showBlackRecord(customerInfo);
    }
}
