package com.jorge.bakeryapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jorge.bakeryapi.model.base.BaseEntity;
import com.jorge.bakeryapi.model.composite.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Column(length = 15, nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
