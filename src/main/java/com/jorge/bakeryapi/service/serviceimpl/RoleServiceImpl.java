package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.RoleDto;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.repository.RoleRepository;
import com.jorge.bakeryapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(RoleDto dto) {
        Role role = new Role();
        modelMapper.map(dto, role);
        return roleRepository.save(role);
    }

    @Override
    public Role updateInfo(RoleDto dto, Long id) {
        Role roleToUpdate = roleRepository.findById(id).orElse(null);
        modelMapper.map(dto, roleToUpdate);
        return roleRepository.save(roleToUpdate);
    }

    @Override
    public void delete(Long id) {
        Role roleToDelete = roleRepository.findById(id).orElse(null);
        roleToDelete.setIsEnabled(false);
        roleRepository.save(roleToDelete);
    }
}
