package com.github.bartkoo98.traveltreasuresfinal.category;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByNameIgnoreCase(String name);
}
