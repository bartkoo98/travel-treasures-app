package com.github.bartkoo98.traveltreasuresfinal.controllers;

import com.github.bartkoo98.traveltreasuresfinal.user.UserService;
import com.github.bartkoo98.traveltreasuresfinal.user.registration.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rejestracja")
    public String registration(Model model) {
        UserRegistrationDto userRegistration = new UserRegistrationDto();
        model.addAttribute("user", userRegistration);
        return "registration";
    }

    @PostMapping("/rejestracja")
    public String register(UserRegistrationDto userRegistration) {
        userService.registerUserWithDefaultRole(userRegistration);
        return "redirect:/";
    }
}
