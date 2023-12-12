package com.jorge.bakeryapi.dto;

import com.jorge.bakeryapi.model.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CategoryDto {
    @Size(min = 5, max = 50, message = "Category name must be between 5 and 50 characters long.")
    @NotBlank(message = "Category name cannot be empty")
    private String name;
    @Size(max = 100, message = "Category description must be under 100 characters long.")
    private String description;
}
