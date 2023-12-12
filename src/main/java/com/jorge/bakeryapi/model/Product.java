package com.jorge.bakeryapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jorge.bakeryapi.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    @Column(length = 100, nullable = false, unique = true)
    private String name;
    @Column(length = 200)
    private String description;
    @Column(nullable = false, columnDefinition = "decimal(6,2)")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private Category category;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product product)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, price);
    }
}
