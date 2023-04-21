package com.github.bartkoo98.traveltreasuresfinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String getAdminOptions() {
        return "admin";
    }
}
