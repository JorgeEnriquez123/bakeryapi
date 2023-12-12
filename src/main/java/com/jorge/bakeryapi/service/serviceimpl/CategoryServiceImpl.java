package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.CategoryDto;
import com.jorge.bakeryapi.handlers.exceptions.CategoryAlreadyExists;
import com.jorge.bakeryapi.handlers.exceptions.NotFoundException;
import com.jorge.bakeryapi.model.Category;
import com.jorge.bakeryapi.repository.CategoryRepository;
import com.jorge.bakeryapi.service.serviceinterface.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category with ID: " + id + " Not found"));
    }

    @Override
    public Category save(CategoryDto dto) {
        Category category = checkCategoryIfAvailable(dto.getName());
        modelMapper.map(dto, category);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateInfo(CategoryDto dto, Long id) {
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category with ID: " + id + " Not found"));
        if(!dto.getName().equals(categoryToUpdate.getName())) {
            checkCategoryIfAvailable(dto.getName());
        }
        modelMapper.map(dto, categoryToUpdate);
        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public Category enable(Long id) {
        Category categoryToEnable = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category with ID: " + id + " Not found"));
        categoryToEnable.setIsEnabled(true);
        return categoryRepository.save(categoryToEnable);
    }

    @Override
    public Category disable(Long id) {
        Category categoryToDelete = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category with ID: " + id + " Not found"));
        categoryToDelete.setIsEnabled(false);
        return categoryRepository.save(categoryToDelete);
    }

    @Override
    public Category checkCategoryIfAvailable(String categoryName) {
        Category category = categoryRepository.findByName(categoryName).orElse(new Category());
        if(!category.equals(new Category())){
            throw new CategoryAlreadyExists("Category name: '" + categoryName + "' already exits");
        }
        return category;
    }
}
