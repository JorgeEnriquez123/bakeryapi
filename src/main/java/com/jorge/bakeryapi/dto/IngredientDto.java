package com.jorge.bakeryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class IngredientDto {
    @Size(min = 5, max = 100, message = "Ingredient name must be between 5 and 100 characters long.")
    @NotBlank(message = "Ingredient name cannot be empty")
    private String name;
    @Size(max = 200, message = "Ingredient description must be under 200 characters long.")
    private String description;
}
