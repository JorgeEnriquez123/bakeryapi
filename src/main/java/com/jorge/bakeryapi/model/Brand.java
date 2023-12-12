package com.jorge.bakeryapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jorge.bakeryapi.model.base.BaseEntity;
import com.jorge.bakeryapi.model.composite.IngredientBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Role
public class Brand extends BaseEntity {
    @Column(length = 100, nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<IngredientBrand> ingredients = new HashSet<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Brand brand)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
