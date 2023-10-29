package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.request.CategoryDto;
import com.thienday.posmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController{
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity saveCaterory(@RequestBody CategoryDto categoryDto){
        return this.execute(t -> categoryService.saveCategory(categoryDto),"Save category successfully");
    }

    @GetMapping("/all")
    public ResponseEntity getAllCaterories(){
        return this.execute(t -> categoryService.getAllCategories(),"Retrieved data successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody Set<Long> ids){
        return this.execute(t -> categoryService.deleteCategory(ids),"Deleted categories successfully");
    }
}
