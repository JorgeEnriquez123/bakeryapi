package com.jorge.bakeryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @Size(min = 5, max = 15, message = "Username must have more than 4 characters and less than 15 characters")
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Size(min = 6, message = "Password must have at least 6 characters")
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
