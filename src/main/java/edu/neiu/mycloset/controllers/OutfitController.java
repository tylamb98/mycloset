package edu.neiu.mycloset.controllers;

import edu.neiu.mycloset.data.OutfitRepository;
import edu.neiu.mycloset.models.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
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

    private OutfitRepository outfitRepo;

    //Autowired Constructor
    @Autowired
    public OutfitController(OutfitRepository outfitRepo) {
        this.outfitRepo = outfitRepo;

    }

    @GetMapping
    public String displayOutfit (Model model) {
        model.addAttribute("outfit", new Outfit()); //Bind  with outfit html object.
        return "add-outfit";        //returning the view
    }

    //modified post method
    @PostMapping
    public String handleOutfitForm(@ModelAttribute("outfit") Outfit outfit) {
        this.outfitRepo.save(outfit);
        return "redirect:/index-page";
    }


}
