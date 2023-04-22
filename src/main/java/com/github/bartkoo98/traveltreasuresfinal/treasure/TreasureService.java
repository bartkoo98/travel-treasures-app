package com.github.bartkoo98.traveltreasuresfinal.treasure;


import com.github.bartkoo98.traveltreasuresfinal.category.Category;
import com.github.bartkoo98.traveltreasuresfinal.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreasureService {
    private final TreasureRepository treasureRepository;
    private final CategoryRepository categoryRepository;

    public TreasureService(TreasureRepository treasureRepository, CategoryRepository categoryRepository) {
        this.treasureRepository = treasureRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<TreasureDto> findAllPromotedTreasures() {
        return treasureRepository.findAllByPromotedIsTrue().stream()
                .map(TreasureDtoMapper::map)
                .toList();
    }

    public Optional<TreasureDto> findTreasureById(Long id) {
        return treasureRepository.findById(id).map(TreasureDtoMapper::map);
    }

    public List<TreasureDto> findTreasuresByCategoryName(String category) {
        return treasureRepository.findAllByCategory_NameIgnoreCase(category)
                .stream()
                .map(TreasureDtoMapper::map)
                .toList();
    }

    public void addTreasure(TreasureSaveDto treasureToSave) {
        Treasure treasure = new Treasure();
        treasure.setTitle(treasureToSave.getTitle());
        treasure.setDestination(treasureToSave.getDestination());
        treasure.setDates(treasureToSave.getDates());
        treasure.setPrice(treasureToSave.getPrice());
        treasure.setLink(treasureToSave.getLink());
        treasure.setDescription(treasureToSave.getDescription());
        treasure.setPromoted(treasureToSave.isPromoted());
        Category category = categoryRepository.findByNameIgnoreCase(treasureToSave.getCategory()).orElseThrow();
        treasure.setCategory(category);
        treasureRepository.save(treasure);
    }
}
