package com.treino.senai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treino.senai.models.Psicologo;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
    Optional<Psicologo> findByEmail(String email);

    Optional<Psicologo> findByUsername(String username);
}

