package com.jorge.bakeryapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jorge.bakeryapi.model.base.BaseEntity;
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
public class Category extends BaseEntity {
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    @Column(length = 200)
    private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @JsonBackReference
    private Set<Product> products = new HashSet<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Category category)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(name, category.name) && Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description);
    }
}
