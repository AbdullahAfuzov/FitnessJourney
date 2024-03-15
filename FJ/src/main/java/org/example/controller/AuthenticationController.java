package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.RequestDTO;
import org.example.dto.ResponseDTO;
import org.example.models.services.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.config.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserDetailsServiceImplementation userDetailsService;

    @PostMapping("/api/v1/login")
    public ResponseEntity<ResponseDTO> authenticateAndGetToken(@Valid @RequestBody RequestDTO authRequestDTO){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
            );

            if(authentication.isAuthenticated()){
                ResponseDTO jwtResponse = ResponseDTO.builder()
                        .accessToken(jwtService.generateToken(authRequestDTO.getUsername()))
                        .build();
                return ResponseEntity.ok(jwtResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO("Authentication failed: " + e.getMessage()));
        }
    }

    @PostMapping("/api/v1/user/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RequestDTO userDTO) {
        RequestDTO registeredUser = userDetailsService.registerNewUser(userDTO, "User");
        if(registeredUser != null) {
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User registration failed", HttpStatus.BAD_REQUEST);
        }
    }
}
