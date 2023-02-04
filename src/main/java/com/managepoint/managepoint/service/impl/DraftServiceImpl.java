package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.entity.BroadCast;
import com.managepoint.managepoint.entity.Draft;
import com.managepoint.managepoint.pojo.BroadCastPojo;
import com.managepoint.managepoint.pojo.DraftPojo;
import com.managepoint.managepoint.repo.DraftRepo;
import com.managepoint.managepoint.service.DraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DraftServiceImpl implements DraftService {

    private final DraftRepo draftRepo;
    @Override
    public DraftPojo save(DraftPojo draftPojo) {
        Draft draft = new Draft();
        draft.setId(draftPojo.getId());
        draft.setEmail(draftPojo.getEmail());
        draft.setTopic(draftPojo.getTopic());
        draft.setDescription(draftPojo.getDescription());
        draftRepo.save(draft);
        return new DraftPojo(draft);
    }

    @Override
    public List<Draft> fetchAll() {
        return this.draftRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        draftRepo.deleteById(id);
    }
}
