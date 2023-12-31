package com.jorge.bakeryapi.model.composite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.model.base.BaseCompositeEntity;
import com.jorge.bakeryapi.model.composite.pkclasses.UserRolePK;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user_role")
@IdClass(UserRolePK.class)
public class UserRole extends BaseCompositeEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Role role;
}

