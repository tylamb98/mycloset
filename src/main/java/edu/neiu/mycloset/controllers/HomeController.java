package edu.neiu.mycloset.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index-page")
public class HomeController {

    @GetMapping
    public String getHomePage() {
        return "index-page";
    }
}
