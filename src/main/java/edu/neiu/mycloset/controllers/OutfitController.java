package edu.neiu.mycloset.controllers;

import edu.neiu.mycloset.models.Outfit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/outfit")
public class OutfitController {

    @GetMapping
    public String displayOutfit (Model model) {
        model.addAttribute("outfit", new Outfit()); //Bind  with outfit html object.
        return "add-outfit";        //returning the view
    }


    @PostMapping
    public String handleOutfitForm(@ModelAttribute("outfit") Outfit outfit) {
        System.out.println("Top: " + outfit.getTop());
        System.out.println("Bottoms: " + outfit.getBottom());
        System.out.println("Shoes: " + outfit.getShoes());
        return "redirect:/index-page";
    }


}
