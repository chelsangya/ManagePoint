package com.managepoint.managepoint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {
//    public String getDashboard(){
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

    @GetMapping("/learn")
    public String getBlogs() {
        return "learn";
    }
    @GetMapping("/profile")
    public String getProfile(){return "accountdetails";}

}
