package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.BroadCast;
import com.managepoint.managepoint.pojo.BroadCastPojo;

import java.util.List;

public interface BroadCastService {
    BroadCastPojo save(BroadCastPojo broadCastPojo);

    List<BroadCast> fetchAll();

    void deleteById(Integer id);
}
