package edu.neiu.mycloset.controllers;

import edu.neiu.mycloset.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index-page")
public class HomeController {

    @GetMapping
    public String getHomePage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("User", user);
        return "index-page";
    }




}
