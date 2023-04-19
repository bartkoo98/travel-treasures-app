package com.github.bartkoo98.traveltreasuresfinal.treasure;

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
