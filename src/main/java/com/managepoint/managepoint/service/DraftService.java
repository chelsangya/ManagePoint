package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.BroadCast;
import com.managepoint.managepoint.entity.Draft;
import com.managepoint.managepoint.pojo.DraftPojo;

import java.util.List;

public interface DraftService {
    DraftPojo save(DraftPojo draftPojo);

    List<Draft> fetchAll();

    void deleteById(Integer id);

}
