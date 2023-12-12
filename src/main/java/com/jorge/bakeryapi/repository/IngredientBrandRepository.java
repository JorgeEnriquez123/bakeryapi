package com.jorge.bakeryapi.repository;

import com.jorge.bakeryapi.model.composite.IngredientBrand;
import com.jorge.bakeryapi.model.composite.pkclasses.IngredientBrandPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientBrandRepository extends JpaRepository<IngredientBrand, IngredientBrandPK> {
}
