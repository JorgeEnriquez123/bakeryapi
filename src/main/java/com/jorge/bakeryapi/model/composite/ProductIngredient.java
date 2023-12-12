package com.jorge.bakeryapi.model.composite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jorge.bakeryapi.model.Ingredient;
import com.jorge.bakeryapi.model.Product;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.model.base.BaseCompositeEntity;
import com.jorge.bakeryapi.model.composite.pkclasses.ProductIngredientPK;
import com.jorge.bakeryapi.model.composite.pkclasses.UserRolePK;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "product_ingredient")
@IdClass(ProductIngredientPK.class)
public class ProductIngredient extends BaseCompositeEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    @JsonBackReference
    private Ingredient ingredient;
}
