package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.BrandDto;
import com.jorge.bakeryapi.handlers.exceptions.NotFoundException;
import com.jorge.bakeryapi.handlers.exceptions.UniqueViolationException;
import com.jorge.bakeryapi.model.Brand;
import com.jorge.bakeryapi.repository.BrandRepository;
import com.jorge.bakeryapi.service.serviceinterface.BrandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand with ID: " + id + " Not found"));
    }

    @Override
    public Brand save(BrandDto dto) {
        Brand brand = checkBrandIfAvailable(dto.getName());
        modelMapper.map(dto, brand);
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateInfo(BrandDto dto, Long id) {
        Brand brandToUpdate = brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand with ID: " + id + " Not found"));
        if(!dto.getName().equals(brandToUpdate.getName())) {
            checkBrandIfAvailable(dto.getName());
        }
        modelMapper.map(dto, brandToUpdate);
        return brandRepository.save(brandToUpdate);
    }

    @Override
    public Brand enable(Long id) {
        Brand brandToEnable = brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand with ID: " + id + " Not found"));
        brandToEnable.setIsEnabled(true);
        return brandRepository.save(brandToEnable);
    }

    @Override
    public Brand disable(Long id) {
        Brand brandToDelete = brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand with ID: " + id + " Not found"));
        brandToDelete.setIsEnabled(false);
        return brandRepository.save(brandToDelete);
    }

    @Override
    public Brand checkBrandIfAvailable(String brandname) {
        Brand brand = brandRepository.findByName(brandname).orElse(new Brand());
        if(!brand.equals(new Brand())){
            throw new UniqueViolationException("Brand name: '" + brandname + "' already exits");
        }
        return brand;
    }
}
