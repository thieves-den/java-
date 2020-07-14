package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.VisitorInfo;

import java.util.List;

public interface IVisitorInfoBiz {
    List<VisitorInfo> select(VisitorInfo visitorInfo);

    List<VisitorInfo> queryVisit(VisitorInfo visitorInfo);

    void save(VisitorInfo visitor);

    VisitorInfo getOneById(String id);
}
