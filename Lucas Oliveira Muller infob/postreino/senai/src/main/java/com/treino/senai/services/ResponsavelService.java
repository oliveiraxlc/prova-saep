package com.treino.senai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treino.senai.models.Responsavel;
import com.treino.senai.repositories.ResponsavelRepository;



@Service
public class ResponsavelService {
    
    @Autowired
    private ResponsavelRepository responsavelRepository;

    public Long contarResponsavels() {
        return responsavelRepository.count();
    }

    public Responsavel buscarResponsavel(Long id) {
        return responsavelRepository.findById(id).get();
    }

    public List<Responsavel> listaResponsavels() {
        return responsavelRepository.findAll();
    }

    public Boolean deletarResponsavel(Long id) {
        if(responsavelRepository.existsById(id)) {
            responsavelRepository.deleteById(id);
            return true;
        }  
        return false;  
    }

    public Responsavel cadastrarResponsavel(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

      public Responsavel atualizarResponsavel(Long id, Responsavel responsavel) {
        Responsavel responsavelRecuperado = buscarResponsavel(id);
        if (responsavelRecuperado != null) {
            responsavelRecuperado.setId(responsavel.getId());
            if (responsavel.getNome() != null) {
                responsavelRecuperado.setNome(responsavel.getNome());
            }
            return responsavelRepository.save(responsavelRecuperado);
        }
        return null;
    }

}
