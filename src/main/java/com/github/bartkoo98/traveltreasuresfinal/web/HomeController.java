package com.github.bartkoo98.traveltreasuresfinal.web;


import com.github.bartkoo98.traveltreasuresfinal.treasure.TreasureService;
import com.github.bartkoo98.traveltreasuresfinal.treasure.dto.TreasureDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final TreasureService treasureService;

    public HomeController(TreasureService treasureService) {
        this.treasureService = treasureService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<TreasureDto> promotedTreasures = treasureService.findAllPromotedTreasures();
        model.addAttribute("heading", "Promowane znaleziska");
        model.addAttribute("treasures", promotedTreasures);
        return "home-page";
    }
}
