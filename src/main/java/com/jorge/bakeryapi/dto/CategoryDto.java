package com.jorge.bakeryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    @Size(min = 5, max = 50, message = "Category name must be between 5 and 50 characters long.")
    @NotBlank(message = "Category name cannot be empty")
    private String name;
    @Size(max = 100, message = "Category description must be under 100 characters long.")
    private String description;
}
