package com.github.bartkoo98.traveltreasuresfinal.treasure;

import com.github.bartkoo98.traveltreasuresfinal.treasure.dto.TreasureDto;

public class TreasureDtoMapper {
    static TreasureDto map(Treasure treasure) {
        return new TreasureDto(
                treasure.getId(),
                treasure.getTitle(),
                treasure.getDestination(),
                treasure.getDates(),
                treasure.getPrice(),
                treasure.getLink(),
                treasure.getDescription(),
                treasure.isPromoted(),
                treasure.getCategory().getName()
        );
    }
}
