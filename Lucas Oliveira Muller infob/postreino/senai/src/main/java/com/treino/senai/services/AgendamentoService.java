package com.treino.senai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treino.senai.models.Agendamento;
import com.treino.senai.repositories.AgendamentoRepository;



@Service
public class AgendamentoService {
    
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Long contarAgendamentos() {
        return agendamentoRepository.count();
    }

    public Agendamento buscarAgendamento(Long id) {
        return agendamentoRepository.findById(id).get();
    }

    public List<Agendamento> listaAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Boolean deletarAgendamento(Long id) {
        if(agendamentoRepository.existsById(id)) {
            agendamentoRepository.deleteById(id);
            return true;
        }  
        return false;  
    }

    public Agendamento cadastrarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }


}
