package com.github.bartkoo98.traveltreasuresfinal.category;

public class CategoryDtoMapper {
    static CategoryDto map(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }
}
