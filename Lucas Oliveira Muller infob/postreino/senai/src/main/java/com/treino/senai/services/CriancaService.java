package com.treino.senai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treino.senai.models.Crianca;
import com.treino.senai.repositories.CriancaRepository;



@Service
public class CriancaService {
    
    @Autowired
    private CriancaRepository criancaRepository;

    public Long contarCriancas() {
        return criancaRepository.count();
    }

    public Crianca buscarCrianca(Long id) {
        return criancaRepository.findById(id).get();
    }

    public List<Crianca> listaCriancas() {
        return criancaRepository.findAll();
    }

    public Boolean deletarCrianca(Long id) {
        if(criancaRepository.existsById(id)) {
            criancaRepository.deleteById(id);
            return true;
        }  
        return false;  
    }

    public Crianca cadastrarCrianca(Crianca crianca) {
        return criancaRepository.save(crianca);
    }

      public Crianca atualizarCrianca(Long id, Crianca crianca) {
        Crianca criancaRecuperado = buscarCrianca(id);
        if (criancaRecuperado != null) {
            criancaRecuperado.setId(crianca.getId());
            if (crianca.getNome() != null) {
                criancaRecuperado.setNome(crianca.getNome());
            }
            return criancaRepository.save(criancaRecuperado);
        }
        return null;
    }

}
