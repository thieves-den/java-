package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.Visitor;

/**
 * @author mangzhong
 */
public interface VisitorBiz {
    Visitor getOneById(String id) ;

    void save(Visitor visitor);
}
