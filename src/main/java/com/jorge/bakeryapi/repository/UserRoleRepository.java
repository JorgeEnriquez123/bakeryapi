package com.jorge.bakeryapi.repository;

import com.jorge.bakeryapi.model.composite.UserRole;
import com.jorge.bakeryapi.model.composite.pkclasses.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {
}
