package edu.neiu.mycloset.controllers;

import edu.neiu.mycloset.models.Outfit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outfit")
public class OutfitController {

    @GetMapping
    public String addOutfit (Model model) {
        model.addAttribute("outfit", new Outfit());
        return "add-outfit";
    }

}
