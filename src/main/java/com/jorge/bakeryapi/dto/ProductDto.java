package com.jorge.bakeryapi.dto;

import com.jorge.bakeryapi.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    @Size(min = 5, max = 100, message = "Product name must be between 5 and 100 characters long.")
    @NotBlank(message = "Product name cannot be empty")
    private String name;
    @Size(max = 100, message = "Product description must be under 100 characters long.")
    private String description;
    @Min(value = 0, message = "Price must be greater or equal than 0")
    private BigDecimal price;
}
