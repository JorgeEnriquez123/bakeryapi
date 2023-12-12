package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.dto.CategoryDto;
import com.jorge.bakeryapi.model.Category;
import com.jorge.bakeryapi.model.Role;

public interface CategoryService extends GenericInterfaceService<Category, CategoryDto> {
    Category checkCategoryIfAvailable(String categoryName);
}
