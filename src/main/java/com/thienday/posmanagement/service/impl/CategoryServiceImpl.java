package com.thienday.posmanagement.service.impl;

import com.thienday.posmanagement.entity.Category;
import com.thienday.posmanagement.repository.CategoryRepository;
import com.thienday.posmanagement.request.CategoryDto;
import com.thienday.posmanagement.response.CategoryResponse;
import com.thienday.posmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryResponse saveCategory(CategoryDto categoryDto) {
        if(Objects.nonNull(categoryDto.getCategoryId())) {
            Category update = categoryRepository.getReferenceById(categoryDto.getCategoryId());
            if(update == null){
                throw new RuntimeException("Supplier id not found !");
            }
            return CategoryResponse.toResponse(categoryRepository.save(CategoryDto.update(update,categoryDto)));
        }
        return CategoryResponse.toResponse(categoryRepository.save(CategoryDto.create(categoryDto)));
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAllByIsDeletedFalse().stream()
                .map(CategoryResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteCategory(Set<Long> ids) {
        categoryRepository.deleteCategoryInIds(ids);
        return true;
    }
}
