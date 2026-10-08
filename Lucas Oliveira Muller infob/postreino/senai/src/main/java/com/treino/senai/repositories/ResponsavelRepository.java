package com.treino.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treino.senai.models.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{
    
}

