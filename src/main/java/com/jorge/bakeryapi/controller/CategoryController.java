package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.CategoryDto;
import com.jorge.bakeryapi.model.Category;
import com.jorge.bakeryapi.service.serviceinterface.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping("")
    public Category saveCategory(@Valid @RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @PutMapping("/{id}")
    public Category updateCategoryInfo(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Long id){
        return categoryService.updateInfo(categoryDto, id);
    }

    @PatchMapping("/enable/{id}")
    public Category enableCategory(@PathVariable Long id){
        return categoryService.enable(id);
    }

    @PatchMapping("/disable/{id}")
    public Category disableCategory(@PathVariable Long id){
        return categoryService.disable(id);
    }
}
