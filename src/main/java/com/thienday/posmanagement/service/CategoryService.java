package com.thienday.posmanagement.service;

import com.thienday.posmanagement.response.CategoryResponse;
import com.thienday.posmanagement.request.CategoryDto;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    CategoryResponse saveCategory(CategoryDto categoryDto);

    List<CategoryResponse> getAllCategories();

    boolean deleteCategory(Set<Long> ids);
}
