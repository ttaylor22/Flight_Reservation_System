package com.group.FRS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.group.FRS.model.UserCredential;
import com.group.FRS.service.IUser_CredentialService;
import com.group.FRS.service.SecurityService;
import com.group.FRS.validator.UserValidator;

@Controller
public class UserCredentialController {
    @Autowired
    private IUser_CredentialService userCredentialService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserCredential());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserCredential userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userCredentialService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "home";
    }
}