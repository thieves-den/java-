package com.igeekhome.ccsv2.biz.impl;

import com.igeekhome.ccsv2.biz.ITagsBiz;
import com.igeekhome.ccsv2.entity.Tags;
import com.igeekhome.ccsv2.mapper.CustomerServiceGroupMapper;
import com.igeekhome.ccsv2.mapper.TagsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsBizImpl implements ITagsBiz {
    @Autowired
    private TagsMapper tagsMapper;

    @Override
    public int save(Tags tags) {
        return tagsMapper.save(tags);
    }

    @Override
    public int delete(int id) {
        return tagsMapper.delete(id);
    }

    @Override
    public int update(String name,int id) {
        return tagsMapper.update(name,id);
    }
}
