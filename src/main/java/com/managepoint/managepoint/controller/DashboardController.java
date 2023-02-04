package com.managepoint.managepoint.controller;

import com.managepoint.managepoint.entity.*;
import com.managepoint.managepoint.pojo.*;
import com.managepoint.managepoint.service.*;
import com.managepoint.managepoint.service.impl.SubscriberServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {
    private  final SubscriberService subscriberService;
    private  final SubscriberServiceImpl subscriberServiceImpl;
    private  final DraftService draftService;
    private final JavaMailSender getJavaMailSender;

    private  final NewsLetterService newsLetterService;


    @Autowired
    UserService userService;
    private final BroadCastService broadCastService;
    User user;
//    @GetMapping("")
//    public String getDashboard(Model model){
//        Optional<User> user = userService.getCurrentUser();
//        model.addAttribute("profileName", user.getName());
//        return "analytics";
//    }

    @GetMapping("/broadcast")
    public String getBroadcast(Model model) {
        List<BroadCast> broadCasts = broadCastService.fetchAll();
        model.addAttribute("broadcasts", broadCasts);
        return "broadcast";
    }
    @GetMapping("")
    public  String getDashboard(Model model){
//        Optional<User> user = userService.getCurrentUser();
//        model.addAttribute("profileName", user.get().getName());

        Long subs=subscriberServiceImpl.countRows();
        model.addAttribute("subs",subs);
        return "analytics";
    }

    @GetMapping("/broadcast/new")
    public String newBroadcast(Model model) {
        model.addAttribute("broadcast",new BroadCastPojo());
        return "newbroadcast";
    }

    @PostMapping("/saveBroadcast")
    public String saveBroadCast(@Valid BroadCastPojo broadCastPojo, @RequestParam String action, @Valid DraftPojo draftPojo,@ModelAttribute User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Hello!");
        message.setText("Subscriber");
        getJavaMailSender.send(message);
        if (action.equals("save")) {
            broadCastService.save(broadCastPojo);
        } else if (action.equals("draft")) {
            draftService.save(draftPojo);
        }

        return "redirect:/dashboard/broadcast";
    }
    @GetMapping("/deleteBroad/{id}")
    public  String deleteBroadCast(@PathVariable("id") Integer id) {
        broadCastService.deleteById(id);
        return "redirect:/dashboard/broadcast";
    }

    @GetMapping("/draft")
    public String getDraftPage(Model model) {
        List<Draft> drafts= draftService.fetchAll();
        model.addAttribute("findDraft", drafts);
        return "broadcast-draft";
    }
    @GetMapping("/deletedraft/{id}")
    public  String deleteDraft(@PathVariable("id") Integer id) {
        draftService.deleteById(id);
        return "redirect:/dashboard/draft";
    }


    @GetMapping("/subscriber")
    public String getGallery(Model model) {
        List<Subscriber> subscribers=subscriberService.fetchAll();
        model.addAttribute("subscriber",new SubscriberPojo());
        model.addAttribute("subscribers",subscribers);
        Long subs=subscriberServiceImpl.countRows();
        model.addAttribute("subs",subs);
        return "subscriber";
    }

    @PostMapping("/savesubscriber")
    public String savesub(@Valid SubscriberPojo subscriberPojo) {
        subscriberService.save(subscriberPojo);
        return "redirect:/dashboard/subscriber";
    }


    @GetMapping("/deletesub/{id}")
    public  String deleteSub(@PathVariable("id") Integer id) {
        subscriberService.deleteById(id);
        return "redirect:/dashboard/subscriber";
    }


    @GetMapping("/help")
    public  String getHelp(){
        return "faq";
    }

    @GetMapping("/learn")
    public String getBlogs(Model model) {
        List<Newsletter> newsletters=newsLetterService.fetchAll();
        model.addAttribute("newsletter",newsletters);
        return "newsletter";
    }


    @GetMapping("/add-newsletter")
    public String getAddnewsletter(Model model) {
        model.addAttribute("newsletter",new NewsletterPojo());
        return "newsletter_upload";
    }

    @PostMapping("/saveNewsletter")
    public String saveBroadCast(@Valid NewsletterPojo newsletterPojo) {
            newsLetterService.save(newsletterPojo);
        return "redirect:/dashboard/learn";
    }



    @GetMapping("/profile")
    public String getUserProfile (Integer id,Model model, Principal principal) {
        if(principal!=null) {
            model.addAttribute("info", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("update", new UserPojo());
        return "accountdetails";
    }
    @PostMapping("/profile/update")
    public String updateUser(@Valid UserPojo userpojo) {
        userService.update(userpojo);
        return "redirect:/dashboard";
    }
    @GetMapping("/notification")
    public String getNotification(){return "notification";
    }

    @GetMapping("/newsletter")
    public String getNewsletter(){
        return "newsletter";
    }

}
