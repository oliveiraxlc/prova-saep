package com.treino.senai.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.treino.senai.models.AuthRequest;
import com.treino.senai.models.AuthResponse;
import com.treino.senai.services.AuthService;



@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthService authenticationService;

    public AuthController(AuthService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Endpoint público para criar um novo usuário
    @PostMapping("/auth/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    // Endpoint público para realizar login
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    // Endpoint protegido (requer o cabeçalho Authorization: Bearer <token>)
    @GetMapping("/protected/me")
    public ResponseEntity<String> getProtectedData(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok("Olá " + userDetails.getUsername() + ", seu token JWT foi validado com sucesso!");
    }
}