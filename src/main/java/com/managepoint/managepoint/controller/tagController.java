package com.managepoint.managepoint.controller;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.data.DataRestTagsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor //creates the constructor with all required arguments
@RequestMapping()

public class tagController extends BaseController {
    private final TagService tagService;
    @GetMapping("/")
}
