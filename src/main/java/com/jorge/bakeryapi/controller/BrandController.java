package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.BrandDto;
import com.jorge.bakeryapi.model.Brand;
import com.jorge.bakeryapi.service.serviceinterface.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;
    @GetMapping("")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable Long id){
        return brandService.findById(id);
    }

    @PostMapping("")
    public Brand saveBrand(@Valid @RequestBody BrandDto brandDto){
        return brandService.save(brandDto);
    }

    @PutMapping("/{id}")
    public Brand updateBrandInfo(@Valid @RequestBody BrandDto brandDto, @PathVariable Long id){
        return brandService.updateInfo(brandDto, id);
    }

    @PatchMapping("/enable/{id}")
    public Brand enableBrand(@PathVariable Long id){
        return brandService.enable(id);
    }

    @PatchMapping("/disable/{id}")
    public Brand disableBrand(@PathVariable Long id){
        return brandService.disable(id);
    }
}