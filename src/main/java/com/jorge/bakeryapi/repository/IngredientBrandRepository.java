package com.jorge.bakeryapi.repository;

import com.jorge.bakeryapi.model.composite.IngredientBrand;
import com.jorge.bakeryapi.model.composite.pkclasses.IngredientBrandPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientBrandRepository extends JpaRepository<IngredientBrand, IngredientBrandPK> {
    List<IngredientBrand> findByIngredient_Name (String ingredientName);
}
