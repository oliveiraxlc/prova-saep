package com.treino.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.treino.senai.models.Crianca;

@Repository 
public interface CriancaRepository extends JpaRepository<Crianca, Long>{
    
}
