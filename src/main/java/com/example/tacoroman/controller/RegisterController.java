package com.example.tacoroman.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tacoroman.domain.RegistrationForm;
import com.example.tacoroman.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserRepository userRepo;
    private PasswordEncoder encoder;

    public RegisterController(UserRepository userRepo, PasswordEncoder encoder){
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @GetMapping
    public String registerFormString() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form){
        userRepo.save(form.toUser(encoder));
        return "redirect:/login";
    }
    

}
