package com.managepoint.managepoint.controller;


import com.managepoint.managepoint.pojo.TagPojo;
import com.managepoint.managepoint.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor //creates the constructor with all required arguments
@RequestMapping("/dashboard/tag")

public class TagController{
    private final TagService tagService;
    @GetMapping("/create")
    public String createTag(Model model) {
        model.addAttribute("tag", new TagPojo());
        return "subscriber";
    }

    @PostMapping("/save")
    public String saveTag(@Valid TagPojo tagpojo) {
        tagService.save(tagpojo);
        return "redirect:/subscriber";
    }
}
