package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.UserDto;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.service.serviceinterface.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("")
    public User saveUser(@Valid @RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @PutMapping("/{id}")
    public User updateUserInfo(@Valid @RequestBody UserDto userDto, @PathVariable Long id){
        return userService.updateInfo(userDto, id);
    }

    @PatchMapping("/enable/{id}")
    public User enableUser(@PathVariable Long id){
        return userService.enable(id);
    }

    @PatchMapping("/disable/{id}")
    public User disableUser(@PathVariable Long id){
        return userService.disable(id);
    }

    @PatchMapping("/{userid}/assignrole/{roleid}")
    public User assignRoleToUser(@PathVariable Long userid, @PathVariable Long roleid){
        return userService.assignRole(userid, roleid);
    }

    @PatchMapping("/{userid}/removeRole/{roleid}")
    public User removeRoleFromUser(@PathVariable Long userid, @PathVariable Long roleid){
        return userService.removeRole(userid, roleid);
    }

    @DeleteMapping("/{userid}")
    public void listss(@PathVariable Long userid){
        User user = userService.findById(userid);
        System.out.println(userService.findById(userid).getRoles());
    }
}
