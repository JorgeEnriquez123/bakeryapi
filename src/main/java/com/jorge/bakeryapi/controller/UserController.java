package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.UserDto;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.service.serviceinterface.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
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

    @PostMapping("")
    public Object saveUser(@Valid @RequestBody UserDto userDto){
        return userService.save(userDto);
    }
}
