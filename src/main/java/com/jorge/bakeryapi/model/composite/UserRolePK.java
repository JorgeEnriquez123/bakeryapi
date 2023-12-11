package com.jorge.bakeryapi.model.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePK implements Serializable {
    Long user;
    Long role;
}
