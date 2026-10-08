package com.treino.senai.repositories;

import com.treino.senai.models.Agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
    
}
