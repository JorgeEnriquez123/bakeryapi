package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.dto.IngredientDto;
import com.jorge.bakeryapi.model.Ingredient;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.model.composite.IngredientBrand;

import java.math.BigDecimal;

public interface IngredientService extends GenericInterfaceService<Ingredient, IngredientDto> {
    IngredientBrand assignBrand(Long ingredientid, Long brandid, BigDecimal price);
    void removeBrand(Long ingredientid, Long brandid);
    Ingredient checkIngredientIfAvailable(String ingredientName);
}
