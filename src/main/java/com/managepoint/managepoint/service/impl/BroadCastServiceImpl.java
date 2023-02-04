package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.entity.BroadCast;
import com.managepoint.managepoint.pojo.BroadCastPojo;
import com.managepoint.managepoint.repo.BroadCastRepo;
import com.managepoint.managepoint.service.BroadCastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BroadCastServiceImpl implements BroadCastService {
    private final BroadCastRepo broadCastRepo;

    @Override
    public BroadCastPojo save(BroadCastPojo broadCastPojo) {
        BroadCast broadCast = new BroadCast();
        broadCast.setId(broadCastPojo.getId());
        broadCast.setEmail(broadCastPojo.getEmail());
        broadCast.setTopic(broadCastPojo.getTopic());
        broadCast.setDescription(broadCastPojo.getDescription());
        broadCastRepo.save(broadCast);
        return new BroadCastPojo(broadCast);
    }

    @Override
    public List<BroadCast> fetchAll() {
        return this.broadCastRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        broadCastRepo.deleteById(id);
    }
}
