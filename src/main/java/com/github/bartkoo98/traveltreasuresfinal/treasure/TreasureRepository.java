package com.github.bartkoo98.traveltreasuresfinal.treasure;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TreasureRepository extends CrudRepository<Treasure, Long> {
    List<Treasure> findAllByPromotedIsTrue();
}
