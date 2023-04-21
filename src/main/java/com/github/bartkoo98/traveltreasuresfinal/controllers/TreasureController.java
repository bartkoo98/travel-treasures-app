package com.github.bartkoo98.traveltreasuresfinal.controllers;

import com.github.bartkoo98.traveltreasuresfinal.category.CategoryService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureDto;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class TreasureController {


    private final TreasureService treasureService;

    public TreasureController(TreasureService treasureService, CategoryService categoryService) {
        this.treasureService = treasureService;
    }

    @GetMapping("/treasure/{id}")
    public String getTreasure(@PathVariable Long id, Model model) {
        TreasureDto treasure = treasureService.findTreasureById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("treasure", treasure);
        return "treasure";
    }

}
