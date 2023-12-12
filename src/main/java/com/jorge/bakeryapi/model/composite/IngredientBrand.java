package com.jorge.bakeryapi.model.composite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jorge.bakeryapi.model.Brand;
import com.jorge.bakeryapi.model.Ingredient;
import com.jorge.bakeryapi.model.Product;
import com.jorge.bakeryapi.model.base.BaseCompositeEntity;
import com.jorge.bakeryapi.model.composite.pkclasses.IngredientBrandPK;
import com.jorge.bakeryapi.model.composite.pkclasses.ProductIngredientPK;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ingredient_brand")
@IdClass(IngredientBrandPK.class)
public class IngredientBrand extends BaseCompositeEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    @JsonManagedReference
    private Ingredient ingredient;
    @Id
    @ManyToOne
    @JoinColumn(name = "brand_id")
    @JsonManagedReference
    private Brand brand;

    @Column(nullable = false, columnDefinition = "decimal(6,2)")
    private BigDecimal price;
}
