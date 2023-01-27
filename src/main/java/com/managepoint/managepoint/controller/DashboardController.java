package com.managepoint.managepoint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/broadcast")
    public String getBroadcast() {
        return "broadcast";
    }

    @GetMapping("/subscriber")
    public String getGallery() {
        return "subscriber";
    }
    @GetMapping("/help")
    public  String getHelp(){return "help";}

    @GetMapping("/learn")
    public String getBlogs() {
        return "learn";
    }
    @GetMapping("/profile")
    public String getProfile(){return "accountdetails";}
    @GetMapping("/notification")
    public String getNotification(){return "notifications";}
    @GetMapping("/newsletter")
    public String getNewsletter(){return "newsletter";}
    @GetMapping("/createtag")
    public String getCreateTag(){return "create_tag";}
}