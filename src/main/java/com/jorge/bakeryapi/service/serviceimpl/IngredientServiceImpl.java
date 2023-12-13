package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.IngredientDto;
import com.jorge.bakeryapi.handlers.exceptions.NotFoundException;
import com.jorge.bakeryapi.handlers.exceptions.UniqueViolationException;
import com.jorge.bakeryapi.model.Brand;
import com.jorge.bakeryapi.model.Ingredient;
import com.jorge.bakeryapi.model.composite.IngredientBrand;
import com.jorge.bakeryapi.model.composite.pkclasses.IngredientBrandPK;
import com.jorge.bakeryapi.repository.BrandRepository;
import com.jorge.bakeryapi.repository.IngredientBrandRepository;
import com.jorge.bakeryapi.repository.IngredientRepository;
import com.jorge.bakeryapi.service.serviceinterface.IngredientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final BrandRepository brandRepository;
    private final IngredientBrandRepository ingredientBrandRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + id + " Not found"));
    }

    @Override
    public Ingredient save(IngredientDto dto) {
        Ingredient ingredient = checkIngredientIfAvailable(dto.getName());
        modelMapper.map(dto, ingredient);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateInfo(IngredientDto dto, Long id) {
        Ingredient ingredientToUpdate = ingredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + id + " Not found"));
        if(!dto.getName().equals(ingredientToUpdate.getName())) {
            checkIngredientIfAvailable(dto.getName());
        }
        modelMapper.map(dto, ingredientToUpdate);
        return ingredientRepository.save(ingredientToUpdate);
    }

    @Override
    public Ingredient enable(Long id) {
        Ingredient ingredientToEnable = ingredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + id + " Not found"));;
        ingredientToEnable.setIsEnabled(true);
        return ingredientRepository.save(ingredientToEnable);
    }

    @Override
    public Ingredient disable(Long id) {
        Ingredient ingredientToDisable = ingredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + id + " Not found"));;
        ingredientToDisable.setIsEnabled(false);
        return ingredientRepository.save(ingredientToDisable);
    }

    @Override
    public IngredientBrand assignBrand(Long ingredientid, Long brandid, BigDecimal price){
        Ingredient ingredientToAssignBrand = ingredientRepository.findById(ingredientid)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + ingredientid + " Not found"));
        Brand brandToAssign = brandRepository.findById(brandid)
                .orElseThrow(() -> new NotFoundException("Brand with ID: " + brandid + " Not found"));

        IngredientBrand ingredientBrand = new IngredientBrand();
        ingredientBrand.setIngredient(ingredientToAssignBrand);
        ingredientBrand.setBrand(brandToAssign);
        ingredientBrand.setPrice(price);
        return ingredientBrandRepository.save(ingredientBrand);
    }

    @Override
    public IngredientBrand removeBrand(Long ingredientid, Long brandid){
        Ingredient ingredientToRemoveBrand = ingredientRepository.findById(ingredientid)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + ingredientid + " Not found"));
        Brand brandToRemove = brandRepository.findById(brandid)
                .orElseThrow(() -> new NotFoundException("Brand with ID: " + brandid + " Not found"));

        IngredientBrandPK ingredientBrandPK = new IngredientBrandPK();
        ingredientBrandPK.setIngredient(ingredientToRemoveBrand.getId());
        ingredientBrandPK.setBrand(brandToRemove.getId());

        IngredientBrand ingredientBrandToRemove = ingredientBrandRepository.findById(ingredientBrandPK).get();
        ingredientBrandRepository.delete(ingredientBrandToRemove);
        return ingredientBrandToRemove;
    }

    @Override
    public List<IngredientBrand> getBrandPrices(Long ingredientid) {
        Ingredient ingredientToSearchBrands = ingredientRepository.findById(ingredientid)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + ingredientid + " Not found"));
        return ingredientBrandRepository.findByIngredient_Name(ingredientToSearchBrands.getName());
    }

    @Override
    public Ingredient checkIngredientIfAvailable(String ingredientname) {
        Ingredient ingredient = ingredientRepository.findByName(ingredientname).orElse(new Ingredient());
        if(!ingredient.equals(new Ingredient())){
            throw new UniqueViolationException("Ingredientname: '" + ingredientname + "' already exits");
        }
        return ingredient;
    }
}
