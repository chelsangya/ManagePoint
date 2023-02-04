package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.Newsletter;
import com.managepoint.managepoint.entity.Subscriber;
import com.managepoint.managepoint.pojo.NewsletterPojo;
import com.managepoint.managepoint.pojo.SubscriberPojo;

import java.util.List;

public interface NewsLetterService {

    NewsletterPojo save(NewsletterPojo NewsletterPojo);
    List<Newsletter> fetchAll();
//    Subscriber fetchById(Integer id);
//    void deleteById(Integer id);
//    SubscriberPojo findByEmail(String email);

}
