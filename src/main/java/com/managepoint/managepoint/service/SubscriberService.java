package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.Subscriber;
import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.SubscriberPojo;
import com.managepoint.managepoint.pojo.UserPojo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow;

public interface SubscriberService {
    SubscriberPojo save(SubscriberPojo subscriberPojo);
    List<Subscriber> fetchAll();
    Subscriber fetchById(Integer id);
    void deleteById(Integer id);
    SubscriberPojo findByEmail(String email);
//    int totalSubscriber(Integer id);

}
