package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.IVisitorInfoBiz;
import com.igeekhome.ccsv2.entity.VisitorInfo;
import com.igeekhome.ccsv2.mapper.VisitorInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorInfoImpl implements IVisitorInfoBiz {
    @Autowired
    VisitorInfoMapper visitorInfoMapper;

    @Override
    public List<VisitorInfo> select(VisitorInfo visitorInfo) {
        return visitorInfoMapper.select(visitorInfo);
    }

    @Override
    public List<VisitorInfo> queryVisit(VisitorInfo visitorInfo) {
        return visitorInfoMapper.queryVisit(visitorInfo);
    }
}
