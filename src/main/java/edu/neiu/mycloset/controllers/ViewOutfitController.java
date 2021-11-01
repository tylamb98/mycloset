package edu.neiu.mycloset.controllers;

import edu.neiu.mycloset.data.OutfitRepository;
import edu.neiu.mycloset.models.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewOutfitController {

    private OutfitRepository outfitRepo;

    @Autowired
    public ViewOutfitController (OutfitRepository outfitRepo) {
        this.outfitRepo = outfitRepo;

    }

    @GetMapping
    public String showFullOutfit(Model model) {
        List<Outfit> outfits = (List<Outfit>) this.outfitRepo.findAll();
        model.addAttribute("outfits", outfits);
        return "display-outfit";
    }

}
