package com.jorge.bakeryapi.config.security;

import com.jorge.bakeryapi.config.security.jwt.JwtService;
import com.jorge.bakeryapi.dto.auth.*;
import com.jorge.bakeryapi.model.User;
import com.jorge.bakeryapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager auth;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request){
        try {
            UsernamePasswordAuthenticationToken authtoken =
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            Authentication authResult = auth.authenticate(authtoken);
            User authenticatedUser = (User) authResult.getPrincipal();

            return LoginResponse.builder()
                    .message("Logged in successfully.")
                    .token(jwtService.getToken(authenticatedUser))
                    .build();
        } catch (Exception e){
            return LoginResponse.builder()
                    .message(e.getMessage())
                    .build();
        }
    }
}
