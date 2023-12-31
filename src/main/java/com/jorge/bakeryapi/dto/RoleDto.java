package com.jorge.bakeryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    @Size(max = 50, message = "Role's name must be less than 50 characters")
    @NotBlank(message = "Role's name cannot be empty")
    private String name;
}
