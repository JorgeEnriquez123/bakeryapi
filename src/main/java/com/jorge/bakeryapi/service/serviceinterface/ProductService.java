package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.dto.ProductDto;
import com.jorge.bakeryapi.model.Product;

public interface ProductService extends GenericInterfaceService<Product, ProductDto>{
    Product assignCategory(Long productid, Long categoryid);
    Product removeCategory(Long productid);

    Product assignIngredient(Long productid, Long ingredientid);
    Product removeIngredient(Long productid, Long ingredientid);
    Product checkProductIfAvailable(String productName);
}
