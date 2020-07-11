package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.IAutoReplyBiz;
import com.igeekhome.ccsv2.entity.AutoReply;
import com.igeekhome.ccsv2.mapper.AutoReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoReplyBizImpl implements IAutoReplyBiz {
    @Autowired
    private AutoReplyMapper autoReplyMapper;

    @Override
    public AutoReply showSetting(int customerServiceId) {
        return autoReplyMapper.showSetting(customerServiceId);
    }

    @Override
    public int saveWelcome(AutoReply autoReply) {
        return autoReplyMapper.saveWelcome(autoReply);
    }

    @Override
    public int saveCSNResponse(AutoReply autoReply) {
        return autoReplyMapper.saveCSNResponse(autoReply);
    }

    @Override
    public int saveCNResponse(AutoReply autoReply) {
        return autoReplyMapper.saveCNResponse(autoReply);
    }

    @Override
    public int saveEnd(AutoReply autoReply) {
        return autoReplyMapper.saveEnd(autoReply);
    }
}
