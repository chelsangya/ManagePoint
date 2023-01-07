package com.managepoint.managepoint.controller;


import com.managepoint.managepoint.exception.AppException;
import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.service.impl.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor //creates the constructor with all required arguments
@RequestMapping("/user")
public class UserController extends BaseController {
    private final UserService userService;
    @GetMapping("/list")
    public String getUserList(Model model){
        List<User> users=userService.fetchAll();
        model.addAttribute("userList",users);
        return "index";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserPojo());
        return "create";
    }
//    @PostMapping("/create")
//    public String createUser(@Valid @ModelAttribute UserPojo userPojo,
//                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        Map<String, String> requestErrors = validateRequest(bindingResult);
//        if (requestErrors != null) {
//            return "redirect:index";
//        }
//        try {
//            userService.save(userPojo);
//            redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");
//        } catch (AppException appException) {
//            redirectAttributes.addFlashAttribute("errorMsg", appException.getMessage());
//        } finally {
//            return "redirect:/index";
//        }
//    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo){
        userService.save(userPojo);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        User user= userService.fetchById(id);
        model.addAttribute("user",new UserPojo(user));
        return "accountdetails";
    }
}
