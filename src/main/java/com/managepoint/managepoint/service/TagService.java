package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.Tag;
import com.managepoint.managepoint.pojo.TagPojo;

import java.util.List;

public interface TagService {
    public void save(TagPojo tagpojo) ;
    List<io.swagger.v3.oas.annotations.tags.Tag> fetchAll();
    Tag fetchById(Integer id);
    void deleteById(Integer id);
}
