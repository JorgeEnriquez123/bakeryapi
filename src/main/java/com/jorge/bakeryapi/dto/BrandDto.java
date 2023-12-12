package com.jorge.bakeryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDto {
    @Size(max = 100, message = "Brand name must be less than 100 characters")
    @NotBlank(message = "Brand name cannot be empty")
    private String name;
}
