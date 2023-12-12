package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.dto.ProductDto;
import com.jorge.bakeryapi.model.Product;

public interface ProductService extends GenericInterfaceService<Product, ProductDto>{
    Product assignCategory(Long productid, Long categoryid);
    Product removeCategory(Long productid);

    Product checkProductIfAvailable(String productName);
}
