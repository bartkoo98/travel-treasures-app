package com.github.bartkoo98.traveltreasuresfinal.controllers;

import com.github.bartkoo98.traveltreasuresfinal.category.CategoryDto;
import com.github.bartkoo98.traveltreasuresfinal.category.CategoryService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class TreasureController {
    private final TreasureService treasureService;
    private final CategoryService categoryService;

    public TreasureController(TreasureService treasureService, CategoryService categoryService) {
        this.treasureService = treasureService;
        this.categoryService = categoryService;
    }

    @GetMapping("/treasure/{id}")
    public String getTreasure(@PathVariable Long id, Model model) {
        TreasureDto treasure = treasureService.findTreasureById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("treasure", treasure);
        return "treasure";
    }

    @GetMapping("/treasure/add-treasure")
    public String addTreasureForm(Model model) {
        List<CategoryDto> allCategories = categoryService.findAllCategories();
        model.addAttribute("categories", allCategories);
        TreasureDto treasure = new TreasureDto();
        model.addAttribute("treasure", treasure);
        return "treasure-add";
    }

    @PostMapping("/treasure/add-treasure")
    public String addTreasure(TreasureDto treasure) {
        treasureService.addTreasure(treasure);
        return "treasure-add";
    }
}
