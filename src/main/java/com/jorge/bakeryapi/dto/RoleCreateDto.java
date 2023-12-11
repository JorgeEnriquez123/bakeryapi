package com.jorge.bakeryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleCreateDto {
    @Size(min = 1, max = 50)
    @NotBlank(message = "Role's name cannot be empty")
    private String name;
}
