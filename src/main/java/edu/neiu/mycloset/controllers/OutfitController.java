package edu.neiu.mycloset.controllers;

import edu.neiu.mycloset.data.OutfitRepository;
import edu.neiu.mycloset.models.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Path;
import javax.validation.Valid;

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

    @GetMapping("/view/{id}")
    public String showOutfit(@PathVariable  Long id, Model model) {
         Outfit outfit = this.outfitRepo.findById(id).get();
         model.addAttribute("outfit" ,  outfit);
         return "view-outfit";
        
    }


    //modified post method
    @PostMapping
    public String handleOutfitForm(@Valid @ModelAttribute("outfit") Outfit outfit, Errors errors) {
        //if i have any errors
        if (errors.hasErrors())
            return "add-outfit";

        this.outfitRepo.save(outfit);
        return "redirect:/index-page";
    }

    @PostMapping("/edit/{id}")
    public String HandleEditStudentForm (@PathVariable Long id, @Valid @ModelAttribute("outfit") Outfit outfit, Errors errors){
        //if i have any errors
        if (errors.hasErrors())
            return "view-outfit";

        try {
            Outfit ogOutfit = this.outfitRepo.findById(id).get();
            updateOgOutfit(ogOutfit, outfit);
            this.outfitRepo.save(ogOutfit);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "invalid email", "Email not available");
            return "view-outfit";
        }


        return "redirect:/index-page";
    }

    private void updateOgOutfit(Outfit original,Outfit update ) {
        original.setTop(update.getTop());
        original.setBottom((update.getBottom()));
        original.setShoes(update.getShoes());
        original.setOutfitName(update.getOutfitName());
    }

    @GetMapping("/delete/{id}")
    public String deleteOutfit(@PathVariable Long id){
        this.outfitRepo.deleteById(id);
        return "redirect:/index-page";

    }

}
