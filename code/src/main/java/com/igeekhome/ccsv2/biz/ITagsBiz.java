package com.igeekhome.ccsv2.biz;

import com.igeekhome.ccsv2.entity.Tags;

public interface ITagsBiz {
    int save(Tags tags);

    int delete(int id);

    int update(String name,int id);
}
