package com.managepoint.managepoint.controller;

import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    UserService userService;
    User user;
//    @GetMapping("")
//    public String getDashboard(Model model){
//        Optional<User> user = userService.getCurrentUser();
//        model.addAttribute("profileName", user.getName());
//        return "analytics";
//    }

    @GetMapping("/broadcast")
    public String getBroadcast() {

        return "broadcast";
    }
    @GetMapping("/broadcast/new")
    public String newBroadcast() {

        return "newbroadcast";
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
        return "faq";
    }
    @GetMapping("/profile")
    public String getUserProfile (Integer id,Model model, Principal principal) {
        model.addAttribute("update", new UserPojo());
        model.addAttribute("info",userService.findByEmail(principal.getName()));
        return "accountdetails";
    }
    @PostMapping("/profile/update")
    public String updateUser(@Valid UserPojo userpojo) {
        userService.update(userpojo);
        return "redirect:/dashboard";
    }
    @GetMapping("/notification")
    public String getNotification(){return "notification";}

}
