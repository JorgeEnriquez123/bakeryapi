package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.model.Product;
import com.jorge.bakeryapi.model.User;

public interface ProductService extends GenericInterfaceService<Product, Long>{
    Product assignCategory(Long productid, Long categoryid);
    Product removeCategory(Long productid, Long categoryid);

    Product checkProductIfAvailable(String productName);
}
