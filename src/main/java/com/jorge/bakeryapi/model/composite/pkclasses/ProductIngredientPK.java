package com.jorge.bakeryapi.model.composite.pkclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductIngredientPK implements Serializable {
    Long product;
    Long ingredient;
}
