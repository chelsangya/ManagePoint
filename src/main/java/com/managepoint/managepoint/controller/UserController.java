package com.managepoint.managepoint.controller;

import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/user/save")
    public String saveUser(@Valid UserPojo userpojo) {
        userService.save(userpojo);
        return "redirect:/index";
    }


//    @GetMapping("user/edit/{id}")
//    public String editUser(@PathVariable("id") Integer id, Model model){
//        User user= userService.fetchById(id);
//        model.addAttribute("user",new UserPojo(user));
//        return "create";
//    }
//    @GetMapping("user/list")
//    public String getUserList(Model model){
//        List<User> users=userService.fetchAll();
//        model.addAttribute("userList",users);
//        return "user/index";
//    }
}
