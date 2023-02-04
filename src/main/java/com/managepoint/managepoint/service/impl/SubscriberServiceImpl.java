package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.entity.Subscriber;
import com.managepoint.managepoint.exception.AppException;
import com.managepoint.managepoint.pojo.SubscriberPojo;
import com.managepoint.managepoint.repo.SubscriberRepo;
import com.managepoint.managepoint.repo.UserRepo;
import com.managepoint.managepoint.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {
    private  final SubscriberRepo subscriberRepo;
    private final UserRepo userRepo;

    @Override
    public SubscriberPojo save(SubscriberPojo subscriberPojo) {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(subscriberPojo.getId());
        subscriber.setEmail(subscriberPojo.getEmail());
        subscriber.setName(subscriberPojo.getName());
        subscriberRepo.save(subscriber);
        return new SubscriberPojo();
    }

    @Override
    public List<Subscriber> fetchAll() {
        return this.subscriberRepo.findAll();
    }

    @Override
    public Subscriber fetchById(Integer id) {
        return subscriberRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        subscriberRepo.deleteById(id);
    }

    @Override
    public SubscriberPojo findByEmail(String email) {
        Subscriber subscriber = subscriberRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new SubscriberPojo(subscriber);
    }


    public Long countRows() {
        return subscriberRepo.countAllRows();
    }

//    @Override
//    public int totalSubscriber(Integer id) {
//        Optional<User> user = userRepo.findById(id);
//        int count = 0;
//        List<Subscriber> subscribers = (List<Subscriber>) subscriberRepo.findAllSub(id);
//
//    }
}
