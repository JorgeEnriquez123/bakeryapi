package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.dto.RoleDto;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.model.User;

public interface RoleService extends GenericInterfaceService<Role, RoleDto> {
    Role checkRoleIfAvailable(String rolename);
}
