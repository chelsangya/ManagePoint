package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.Tag;
import com.managepoint.managepoint.pojo.TagPojo;

import java.util.List;

public interface TagService {
    public void save(TagPojo tagpojo) ;
    List<Tag> fetchAll();
    Tag fetchById(Integer id);
    Tag fetchByName(String name);
    void deleteById(Integer id);
}
