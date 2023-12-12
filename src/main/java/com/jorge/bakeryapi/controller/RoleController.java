package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.RoleDto;
import com.jorge.bakeryapi.model.Role;
import com.jorge.bakeryapi.service.serviceinterface.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
@PreAuthorize("hasAuthority('ADMIN')")
public class RoleController {
    private final RoleService roleService;
    @GetMapping("")
    public List<Role> findAll(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable Long id){
        return roleService.findById(id);
    }

    @PostMapping("")
    public Role saveRole(@Valid @RequestBody RoleDto roleDto){
        return roleService.save(roleDto);
    }

    @PutMapping("/{id}")
    public Role updateRoleInfo(@Valid @RequestBody RoleDto roleDto, @PathVariable Long id){
        return roleService.updateInfo(roleDto, id);
    }

    @PatchMapping("/enable/{id}")
    public Role enableRole(@PathVariable Long id){
        return roleService.enable(id);
    }

    @PatchMapping("/disable/{id}")
    public Role disableRole(@PathVariable Long id){
        return roleService.disable(id);
    }
}
