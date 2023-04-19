package com.github.bartkoo98.traveltreasuresfinal.web;

import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
public class TreasureController {
    private final TreasureService treasureService;

    public TreasureController(TreasureService treasureService) {
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
