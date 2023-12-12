package com.jorge.bakeryapi.service.serviceinterface;

import com.jorge.bakeryapi.dto.UserDto;
import com.jorge.bakeryapi.model.User;

public interface UserService extends GenericInterfaceService<User, UserDto> {
    User assignRole(Long userid, Long roleid);
    User removeRole(Long userid, Long roleid);
    User checkUserIfAvailable(String username);
}
