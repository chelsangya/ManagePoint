package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.entity.Tag;
import com.managepoint.managepoint.pojo.TagPojo;
import com.managepoint.managepoint.repo.TagRepo;
import com.managepoint.managepoint.service.TagService;

import java.util.List;

public class TagServiceImpl implements TagService {
    TagRepo tagRepo;
    @Override
     public void save(TagPojo tagpojo) {
        Tag tag = new Tag();
        tag.setName(tagpojo.getName());
        tagRepo.save(tag);
    }
    @Override
    public List<Tag> fetchAll() {
        return tagRepo.findAll();
    }

    @Override
    public Tag fetchById(Integer id) {
        return tagRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }


    @Override
    public Tag fetchByName(String name) {
        return tagRepo.findByName(name).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        tagRepo.deleteById(id);
    }
}
