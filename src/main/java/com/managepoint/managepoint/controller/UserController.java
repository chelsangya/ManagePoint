package com.managepoint.managepoint.controller;

import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor //creates the constructor with all required arguments
@RequestMapping()
public class UserController extends BaseController {
    private final UserService userService;
    @GetMapping("/user/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "create";
    }

    @PostMapping("/user/saveuser")
    public String saveUser(@Valid UserPojo userpojo) {
        userService.save(userpojo);
        return "redirect:/index";
    }
    @GetMapping("/request-password-reset")
    public String requestPasswordReset() {
        return "request_password_reset";
    }

    @PostMapping("/request-password-reset")
    public String processPasswordResetRequest(@RequestParam("email") String email, Model model) {
        userService.processPasswordResetRequest(email);
        model.addAttribute("message", "A password reset OTP has been sent to your email. Please check your inbox!!!");
        return "reset_password";
    }

    @GetMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        return "reset_password";
    }

    @PostMapping("/reset-password")
    public String processPasswordReset(@RequestParam("email") String email,
                                       @RequestParam(required=false, name = "OTP") String OTP,
                                       @RequestParam("password") String password,
                                       Model model) {
        userService.resetPassword(email, OTP, password);
        model.addAttribute("message", "Your password has been reset successfully.");
        return "redirect:/login";
    }

//    @GetMapping("user/list")
//    public String getUserList(Model model){
//        List<User> users=userService.fetchAll();
//        model.addAttribute("userList",users);
//        return "user/index";
//    }
}
