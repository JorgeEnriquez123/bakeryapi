package com.jorge.bakeryapi.repository;

import com.jorge.bakeryapi.model.Brand;
import com.jorge.bakeryapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findByName (String brandName);
}
