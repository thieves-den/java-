package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ICommonWordBiz;
import com.igeekhome.ccsv2.entity.CommonWord;
import com.igeekhome.ccsv2.mapper.CommonWordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonWordBizImpl implements ICommonWordBiz {
    @Autowired
    private CommonWordMapper commonWordMapper;

    @Override
    public int save(CommonWord commonWord) {
        return commonWordMapper.save(commonWord);
    }
}
