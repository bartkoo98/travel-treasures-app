package com.github.bartkoo98.traveltreasuresfinal.controller;

import com.github.bartkoo98.traveltreasuresfinal.category.CategoryDto;
import com.github.bartkoo98.traveltreasuresfinal.category.CategoryService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureDto;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final TreasureService treasureService;

    public CategoryController(CategoryService categoryService, TreasureService treasureService) {
        this.categoryService = categoryService;
        this.treasureService = treasureService;
    }

    @GetMapping("/category/{name}")
    public String getCategory(@PathVariable String name, Model model) {
        CategoryDto category = categoryService.findCategoryByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<TreasureDto> treasures = treasureService.findTreasuresByCategoryName(name);
        model.addAttribute("heading", category.getName());
        model.addAttribute("description", category.getDescription());
        model.addAttribute("treasures", treasures);
        return "home-page";
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        List<CategoryDto> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }
}
