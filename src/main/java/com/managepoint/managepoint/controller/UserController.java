package com.managepoint.managepoint.controller;


import com.managepoint.managepoint.exception.AppException;
import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.service.impl.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor //creates the constructor with all required arguments
@RequestMapping
public class UserController extends BaseController {
    private final UserService userService;


    @GetMapping("/create")
    public String getRegister(Model model){
        model.addAttribute("user",new UserPojo());
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo){
        System.out.println("controller");
        userService.save(userPojo);
        return "redirect:index";
    }

    @GetMapping("/dashboard/profile/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        User user= userService.fetchById(id);
        model.addAttribute("user",new UserPojo(user));
        return "accountdetails";
    }
}
