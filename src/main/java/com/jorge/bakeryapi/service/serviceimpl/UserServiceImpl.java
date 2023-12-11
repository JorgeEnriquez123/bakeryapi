package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.UserDto;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.repository.RoleRepository;
import com.jorge.bakeryapi.repository.UserRepository;
import com.jorge.bakeryapi.service.serviceinterface.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(UserDto dto) {
        User user = new User();
        modelMapper.map(dto, user);
        return userRepository.save(user);
    }

    @Override
    public User updateInfo(UserDto dto, Long id) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        modelMapper.map(dto, userToUpdate);
        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        User userToDelete = userRepository.findById(id).orElse(null);
        userToDelete.setIsEnabled(false);
        userRepository.save(userToDelete);
    }

    public User assignRole(Long userid, Long roleid){
        User userToAssignRole = userRepository.findById(userid).orElse(null);
        Role roleToAssign = roleRepository.findById(roleid).orElse(null);

        userToAssignRole.getRoles().add(roleToAssign);
        return userRepository.save(userToAssignRole);
    }

    public User removeRole(Long userid, Long roleid){
        User userToRemoveRole = userRepository.findById(userid).orElse(null);
        Role roleToRemove = roleRepository.findById(roleid).orElse(null);

        userToRemoveRole.getRoles().remove(roleToRemove);
        return userRepository.save(userToRemoveRole);
    }
}
