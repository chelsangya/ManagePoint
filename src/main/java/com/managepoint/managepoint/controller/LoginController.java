package com.managepoint.managepoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    @GetMapping("/login")
    public String getPage(){
        return "login";
    }
}
