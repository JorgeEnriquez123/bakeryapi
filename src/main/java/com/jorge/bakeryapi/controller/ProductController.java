package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.ProductDto;
import com.jorge.bakeryapi.model.Product;
import com.jorge.bakeryapi.service.serviceinterface.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping("")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("")
    public Product saveProduct(@Valid @RequestBody ProductDto productDto){
        return productService.save(productDto);
    }

    @PutMapping("/{id}")
    public Product updateProductInfo(@Valid @RequestBody ProductDto productDto, @PathVariable Long id){
        return productService.updateInfo(productDto, id);
    }

    @PatchMapping("/enable/{id}")
    public Product enableProduct(@PathVariable Long id){
        return productService.enable(id);
    }

    @PatchMapping("/disable/{id}")
    public Product disableProduct(@PathVariable Long id){
        return productService.disable(id);
    }

    @PatchMapping("/{productid}/assigncategory/{categoryid}")
    public Product assignCatgoryToProduct(@PathVariable Long productid, @PathVariable Long categoryid){
        return productService.assignCategory(productid, categoryid);
    }

    @PatchMapping("/{productid}/removeCategory")
    public Product removeCategoryFromProduct(@PathVariable Long productid){
        return productService.removeCategory(productid);
    }

    @PatchMapping("/{productid}/assigningredient/{ingredientid}")
    public Product assignIngredientToProduct(@PathVariable Long productid, @PathVariable Long ingredientid){
        return productService.assignIngredient(productid, ingredientid);
    }

    @PatchMapping("/{productid}/removeIngredient/{ingredientid}")
    public Product removeIngredientFromProduct(@PathVariable Long productid, @PathVariable Long ingredientid){
        return productService.removeIngredient(productid, ingredientid);
    }
}
