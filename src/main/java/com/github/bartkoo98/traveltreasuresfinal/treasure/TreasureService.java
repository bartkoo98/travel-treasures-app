package com.github.bartkoo98.traveltreasuresfinal.treasure;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreasureService {
    private final TreasureRepository treasureRepository;

    public TreasureService(TreasureRepository treasureRepository) {
        this.treasureRepository = treasureRepository;
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


}
