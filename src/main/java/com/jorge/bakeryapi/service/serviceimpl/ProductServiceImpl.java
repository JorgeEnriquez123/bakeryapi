package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.ProductDto;
import com.jorge.bakeryapi.handlers.exceptions.NotFoundException;
import com.jorge.bakeryapi.handlers.exceptions.UniqueViolationException;
import com.jorge.bakeryapi.model.*;
import com.jorge.bakeryapi.repository.CategoryRepository;
import com.jorge.bakeryapi.repository.IngredientRepository;
import com.jorge.bakeryapi.repository.ProductRepository;
import com.jorge.bakeryapi.service.serviceinterface.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + id + " Not found"));
    }

    @Override
    public Product save(ProductDto dto) {
        Product product = checkProductIfAvailable(dto.getName());
        modelMapper.map(dto, product);
        return productRepository.save(product);
    }

    @Override
    public Product updateInfo(ProductDto dto, Long id) {
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + id + " Not found"));
        if(!dto.getName().equals(productToUpdate.getName())) {
            checkProductIfAvailable(dto.getName());
        }
        modelMapper.map(dto, productToUpdate);
        return productRepository.save(productToUpdate);
    }

    @Override
    public Product enable(Long id) {
        Product productToEnable = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + id + " Not found"));;
        productToEnable.setIsEnabled(true);
        return productRepository.save(productToEnable);
    }

    @Override
    public Product disable(Long id) {
        Product productToDisable = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + id + " Not found"));;
        productToDisable.setIsEnabled(false);
        return productRepository.save(productToDisable);
    }

    @Override
    public Product assignCategory(Long productid, Long categoryid){
        Product productToAssignCategory = productRepository.findById(productid)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + productid + " Not found"));
        Category categoryToAssign = categoryRepository.findById(categoryid)
                .orElseThrow(() -> new NotFoundException("Category with ID: " + categoryid + " Not found"));

        categoryToAssign.getProducts().add(productToAssignCategory);
        productToAssignCategory.setCategory(categoryToAssign);
        return productRepository.save(productToAssignCategory);
    }

    @Override
    public Product removeCategory(Long productid){
        Product productToRemoveCategory = productRepository.findById(productid)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + productid + " Not found"));
        Category categoryFromProduct = productToRemoveCategory.getCategory();
        if(categoryFromProduct != null){
            categoryFromProduct.getProducts().remove(productToRemoveCategory);
        }
        productToRemoveCategory.setCategory(null);
        return productRepository.save(productToRemoveCategory);
    }

    @Override
    public Product assignIngredient(Long productid, Long ingredientid) {
        Product productToAssignIngredient = productRepository.findById(productid)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + productid + " Not found"));
        Ingredient ingredientToAssign = ingredientRepository.findById(ingredientid)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + ingredientid + " Not found"));

        productToAssignIngredient.getIngredients().add(ingredientToAssign);
        return productRepository.save(productToAssignIngredient);
    }

    @Override
    public Product removeIngredient(Long productid, Long ingredientid) {
        Product productToRemoveIngredient = productRepository.findById(productid)
                .orElseThrow(() -> new NotFoundException("Product with ID: " + productid + " Not found"));
        Ingredient ingredientToRemove = ingredientRepository.findById(ingredientid)
                .orElseThrow(() -> new NotFoundException("Ingredient with ID: " + ingredientid + " Not found"));
        productToRemoveIngredient.getIngredients().remove(ingredientToRemove);
        return productRepository.save(productToRemoveIngredient);
    }

    @Override
    public Product checkProductIfAvailable(String productname) {
        Product product = productRepository.findByName(productname).orElse(new Product());
        if(!product.equals(new Product())){
            throw new UniqueViolationException("Product name: '" + productname + "' already exits");
        }
        return product;
    }
}
