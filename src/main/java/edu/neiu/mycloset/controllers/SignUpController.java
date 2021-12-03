package edu.neiu.mycloset.controllers;


import edu.neiu.mycloset.data.UserRepository;
import edu.neiu.mycloset.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private UserRepository userRepo;

    @Autowired
    public SignUpController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping
    public String handleSignUpForm(@Valid @ModelAttribute("user") User user, Errors errors) {
        if(errors.hasErrors())
            return "signup";
        try {
            this.userRepo.save(user);
        }
        catch (DataIntegrityViolationException e){
            errors.rejectValue("email", "Invalid Email!","You cannot use this email.");
            return "signup";
        }

        return "redirect:/index-page";

    }






}