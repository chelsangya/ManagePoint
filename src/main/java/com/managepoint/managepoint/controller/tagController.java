package com.managepoint.managepoint.controller;

import com.managepoint.managepoint.pojo.TagPojo;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.data.DataRestTagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor //creates the constructor with all required arguments
@RequestMapping()

public class tagController extends BaseController {
    private final TagService tagService;
    @GetMapping("/tag/create")
    public String createtag(Model model) {
        model.addAttribute("tag", new TagPojo());
        return "subscriber";
    }

    @PostMapping("/tag/save")
    public String saveTag(@Valid TagPojo tagpojo) {
        tagService.save(tagpojo);
        return "redirect:/subscriber";
    }
}
