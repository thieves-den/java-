package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ICommonWordBiz;
import com.igeekhome.ccsv2.biz.ICommonWordTypeBiz;
import com.igeekhome.ccsv2.entity.CommonWordType;
import com.igeekhome.ccsv2.mapper.CommonWordMapper;
import com.igeekhome.ccsv2.mapper.CommonWordTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonWordTypeBizImpl implements ICommonWordTypeBiz {
    @Autowired
    private CommonWordTypeMapper commonWordTypeMapper;

    @Override
    public int save(String name,boolean isPersonal,int creatorId) {
        return commonWordTypeMapper.save(name,isPersonal,creatorId);
    }
}
