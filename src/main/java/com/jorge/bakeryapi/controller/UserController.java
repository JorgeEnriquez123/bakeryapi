package com.jorge.bakeryapi.controller;

import com.jorge.bakeryapi.dto.UserDto;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public Object saveUser(@Valid @RequestBody UserDto userDto, BindingResult result){
        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();
            return errors;
        }
        return userService.save(userDto);
    }
}
