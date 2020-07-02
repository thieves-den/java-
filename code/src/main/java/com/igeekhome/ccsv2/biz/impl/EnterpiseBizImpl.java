package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.IEnterpiseBiz;
import com.igeekhome.ccsv2.biz.IWorkOrderBiz;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import com.igeekhome.ccsv2.entity.Enterpise;
import com.igeekhome.ccsv2.entity.WorkOrder;
import com.igeekhome.ccsv2.mapper.EnterpiseMapper;
import com.igeekhome.ccsv2.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EnterpiseBizImpl implements IEnterpiseBiz {

    @Autowired
    private EnterpiseMapper enterpiseMapper;

    @Override
    public int update(Enterpise enterpise) {
        return enterpiseMapper.update(enterpise);
    }
}
