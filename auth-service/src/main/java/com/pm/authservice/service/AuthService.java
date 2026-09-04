package com.pm.authservice.service;

import com.pm.authservice.dto.LoginRequestDTO;
import com.pm.authservice.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // if the request password = password, then it gets encoded into some string - $2345sdfghrf...
    // and then we use the encoded value to compare with the encoded password present in DB
    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO){
        Optional<String> token = userService.findByEmail(loginRequestDTO.getEmail())
                .filter(user -> passwordEncoder.matches(loginRequestDTO.getPassword(),
                        user.getPassword()))
                .map(user -> jwtUtil.generateToken(user.getEmail(), user.getRole()));

        return token;
    }

    public boolean validateToken(String token){
        try {
            jwtUtil.validateToken(token);
            return true;
        } catch (JwtException e){
            return false;
        }
    }
}
