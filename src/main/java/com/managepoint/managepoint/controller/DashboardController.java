package com.managepoint.managepoint.controller;

import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {
//    UserService userService;
//    @GetMapping("")
//    public String getDashboard(Model model){
//        Optional<User> user = userService.getCurrentUser();
//        model.addAttribute("profileName", user.get().getName());
//        return "dashboard";
//    }

    @GetMapping("/broadcast")
    public String getBroadcast() {

        return "broadcast";
    }

    @GetMapping("/subscriber")
    public String getGallery() {

        return "subscriber";
    }
    @GetMapping("/help")
    public  String getHelp(){
        return "faq";
    }

    @GetMapping("/learn")
    public String getBlogs() {

        return "learn";
    }
    @GetMapping("/profile")
    public String getProfile(Model model){
        model.addAttribute("user",new UserPojo());
        return "accountdetails";
    }
    @GetMapping("/notification")
    public String getNotification(){return "notification";}
//    @GetMapping("/createtag")
//    public String getCreateTag(){return "create_tag";}
}
