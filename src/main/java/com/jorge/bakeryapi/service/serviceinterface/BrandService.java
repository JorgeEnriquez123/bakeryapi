package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.dto.BrandDto;
import com.jorge.bakeryapi.model.Brand;
import com.jorge.bakeryapi.model.Role;

public interface BrandService extends GenericInterfaceService<Brand, BrandDto>{
    Brand checkBrandIfAvailable(String brandName);

}
