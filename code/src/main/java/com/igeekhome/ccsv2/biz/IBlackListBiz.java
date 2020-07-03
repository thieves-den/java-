package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.BlackList;

public interface IBlackListBiz {
    int delete(BlackList blackList);

    int create(BlackList blackList);
}
