package com.treino.senai.models;

public record AuthRequest(
    String username, 
    String email, 
    String password) {}
