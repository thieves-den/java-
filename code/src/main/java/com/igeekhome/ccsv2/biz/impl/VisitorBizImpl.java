package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.VisitorBiz;
import com.igeekhome.ccsv2.entity.Visitor;
import com.igeekhome.ccsv2.mapper.VisitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorBizImpl implements VisitorBiz {
    @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public Visitor getOneById(String id) {
        return visitorMapper.getOneById(id);
    }

    @Override
    public void save(Visitor visitor) {
        visitorMapper.insert(visitor);
    }
}
