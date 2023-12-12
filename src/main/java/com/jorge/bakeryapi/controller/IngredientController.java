package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.IngredientDto;
import com.jorge.bakeryapi.dto.IngredientDto;
import com.jorge.bakeryapi.model.Ingredient;
import com.jorge.bakeryapi.model.Ingredient;
import com.jorge.bakeryapi.model.composite.IngredientBrand;
import com.jorge.bakeryapi.service.serviceinterface.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    @GetMapping("")
    public List<Ingredient> findAll(){
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable Long id){
        return ingredientService.findById(id);
    }

    @GetMapping("/{id}/brands")
    public List<IngredientBrand> getBrands(@PathVariable Long id){
        return ingredientService.getBrandPrices(id);
    }

    @PostMapping("")
    public Ingredient saveIngredient(@Valid @RequestBody IngredientDto ingredientDto){
        return ingredientService.save(ingredientDto);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredientInfo(@Valid @RequestBody IngredientDto ingredientDto, @PathVariable Long id){
        return ingredientService.updateInfo(ingredientDto, id);
    }

    @PatchMapping("/enable/{id}")
    public Ingredient enableIngredient(@PathVariable Long id){
        return ingredientService.enable(id);
    }

    @PatchMapping("/disable/{id}")
    public Ingredient disableIngredient(@PathVariable Long id){
        return ingredientService.disable(id);
    }

    @PatchMapping("/{ingredientid}/assignbrand/{brandid}")
    public IngredientBrand assignBrandToIngredient(@PathVariable Long ingredientid, @PathVariable Long brandid, @RequestParam BigDecimal price){
        return ingredientService.assignBrand(ingredientid, brandid, price);
    }

    @PatchMapping("/{ingredientid}/removeBrand/{brandid}")
    public IngredientBrand removeBrandFromIngredient(@PathVariable Long ingredientid, @PathVariable Long brandid){
        return ingredientService.removeBrand(ingredientid, brandid);
    }
}
