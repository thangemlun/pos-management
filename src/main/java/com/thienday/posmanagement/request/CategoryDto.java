package com.thienday.posmanagement.request;

import com.thienday.posmanagement.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String categoryName;

    public CategoryDto(long id, String name) {
        this.categoryId = id ;
        this.categoryName = name;
    }

    public static Category create(CategoryDto dto){
        Category data = new Category();
        data.setName(dto.getCategoryName());
        return data;
    }

    public static Category update(Category data ,CategoryDto dto){
        data.setName(dto.getCategoryName());
        return data;
    }

    public static CategoryDto toDto (Category category){
        return new CategoryDto(category.getId(),category.getName());
    }
}
