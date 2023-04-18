package com.github.bartkoo98.traveltreasuresfinal.web;

import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.dto.TreasureDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class TreasureController {
    private final TreasureService treasureService;

    public TreasureController(TreasureService treasureService) {
        this.treasureService = treasureService;
    }

    @GetMapping("/treasure/{id}")
    public String getTreasure(@PathVariable Long id, Model model) {
        Optional<TreasureDto> optionalTreasure = treasureService.findTreasureById(id);
        optionalTreasure.ifPresent(treasure -> model.addAttribute("treasure", treasure));
        return "treasure";
    }
}
