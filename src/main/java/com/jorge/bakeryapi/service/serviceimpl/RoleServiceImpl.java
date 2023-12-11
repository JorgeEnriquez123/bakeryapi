package com.jorge.bakeryapi.service.serviceimpl;

import com.jorge.bakeryapi.dto.RoleDto;
import com.jorge.bakeryapi.handlers.exceptions.NotFoundException;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.repository.RoleRepository;
import com.jorge.bakeryapi.service.serviceinterface.RoleService;
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
    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role with ID: " + id + " Not found"));
    }

    @Override
    public Role save(RoleDto dto) {
        Role role = new Role();
        modelMapper.map(dto, role);
        return roleRepository.save(role);
    }

    @Override
    public Role updateInfo(RoleDto dto, Long id) {
        Role roleToUpdate = roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role with ID: " + id + " Not found"));
        modelMapper.map(dto, roleToUpdate);
        return roleRepository.save(roleToUpdate);
    }

    @Override
    public Role enable(Long id) {
        Role roleToEnable = roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role with ID: " + id + " Not found"));
        roleToEnable.setIsEnabled(false);
        return roleRepository.save(roleToEnable);
    }

    @Override
    public Role disable(Long id) {
        Role roleToDelete = roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role with ID: " + id + " Not found"));
        roleToDelete.setIsEnabled(false);
        return roleRepository.save(roleToDelete);
    }
}
