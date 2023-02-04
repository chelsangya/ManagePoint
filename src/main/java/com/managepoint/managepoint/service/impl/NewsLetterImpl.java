package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.entity.BroadCast;
import com.managepoint.managepoint.entity.Newsletter;
import com.managepoint.managepoint.entity.Subscriber;
import com.managepoint.managepoint.pojo.BroadCastPojo;
import com.managepoint.managepoint.pojo.NewsletterPojo;
import com.managepoint.managepoint.pojo.SubscriberPojo;
import com.managepoint.managepoint.repo.NewsletterRepo;
import com.managepoint.managepoint.service.NewsLetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NewsLetterImpl implements NewsLetterService {

    private final NewsletterRepo newsletterRepo;
    @Override
    public NewsletterPojo save(NewsletterPojo NewsletterPojo) {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(NewsletterPojo.getId());
        newsletter.setContent(NewsletterPojo.getContent());
        newsletter.setTitle(NewsletterPojo.getTitle());
        newsletterRepo.save(newsletter);
        return new NewsletterPojo(newsletter);    }

    @Override
    public List<Newsletter> fetchAll() {
        return this.newsletterRepo.findAll();
    }


}
