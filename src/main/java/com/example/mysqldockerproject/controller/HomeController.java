package com.example.mysqldockerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // Refers to the 'index.html' file in the 'templates' folder
    }
}
