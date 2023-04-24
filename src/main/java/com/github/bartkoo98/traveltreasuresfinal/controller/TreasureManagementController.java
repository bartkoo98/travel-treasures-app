package com.github.bartkoo98.traveltreasuresfinal.controller;

import com.github.bartkoo98.traveltreasuresfinal.category.CategoryDto;
import com.github.bartkoo98.traveltreasuresfinal.category.CategoryService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureSaveDto;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class TreasureManagementController {
    private final TreasureService treasureService;
    private final CategoryService categoryService;

    public TreasureManagementController(TreasureService treasureService, CategoryService categoryService) {
        this.treasureService = treasureService;
        this.categoryService = categoryService;
    }

    @GetMapping("/znalezisko/dodaj-znalezisko")
    public String addTreasureForm(Model model) {
        List<CategoryDto> allCategories = categoryService.findAllCategories();
        model.addAttribute("categories", allCategories);
        TreasureSaveDto treasure = new TreasureSaveDto();
        model.addAttribute("treasure", treasure);
        return "treasure-add";
    }

    @PostMapping("/znalezisko/dodaj-znalezisko")
    public String addTreasure(TreasureSaveDto treasure, RedirectAttributes redirectAttributes) {
        treasureService.addTreasure(treasure);
        redirectAttributes.addFlashAttribute("notification", "Znalezisko '%s' zostało zapisane".formatted(treasure.getTitle()));
        return "redirect:/";
    }
}
