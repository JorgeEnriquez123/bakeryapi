package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.UserDto;
import com.jorge.bakeryapi.handlers.exceptions.NotFoundException;
import com.jorge.bakeryapi.handlers.exceptions.UniqueViolationException;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.repository.RoleRepository;
import com.jorge.bakeryapi.repository.UserRepository;
import com.jorge.bakeryapi.service.serviceinterface.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with ID: " + id + " Not found"));
    }

    @Override
    public User save(UserDto dto) {
        User user = checkUserIfAvailable(dto.getUsername());
        modelMapper.map(dto, user);
        return userRepository.save(user);
    }

    @Override
    public User updateInfo(UserDto dto, Long id) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with ID: " + id + " Not found"));
        if(!dto.getUsername().equals(userToUpdate.getUsername())) {
            checkUserIfAvailable(dto.getUsername());
        }
        modelMapper.map(dto, userToUpdate);
        return userRepository.save(userToUpdate);
    }

    @Override
    public User enable(Long id) {
        User userToEnable = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with ID: " + id + " Not found"));;
        userToEnable.setIsEnabled(true);
        return userRepository.save(userToEnable);
    }

    @Override
    public User disable(Long id) {
        User userToDisable = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with ID: " + id + " Not found"));;
        userToDisable.setIsEnabled(false);
        return userRepository.save(userToDisable);
    }

    @Override
    public User assignRole(Long userid, Long roleid){
        User userToAssignRole = userRepository.findById(userid)
                .orElseThrow(() -> new NotFoundException("User with ID: " + userid + " Not found"));
        Role roleToAssign = roleRepository.findById(roleid)
                .orElseThrow(() -> new NotFoundException("Role with ID: " + roleid + " Not found"));

        userToAssignRole.getRoles().add(roleToAssign);
        return userRepository.save(userToAssignRole);
    }

    @Override
    public User removeRole(Long userid, Long roleid){
        User userToRemoveRole = userRepository.findById(userid)
                .orElseThrow(() -> new NotFoundException("User with ID: " + userid + " Not found"));
        Role roleToRemove = roleRepository.findById(roleid)
                .orElseThrow(() -> new NotFoundException("Role with ID: " + roleid + " Not found"));

        userToRemoveRole.getRoles().remove(roleToRemove);
        return userRepository.save(userToRemoveRole);
    }

    @Override
    public User checkUserIfAvailable(String username) {
        User user = userRepository.findByUsername(username).orElse(new User());
        if(!user.equals(new User())){
            throw new UniqueViolationException("Username: '" + username + "' already exits");
        }
        return user;
    }
}
