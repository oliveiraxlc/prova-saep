package com.treino.senai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.senai.models.Responsavel;
import com.treino.senai.services.ResponsavelService;



@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping("/contar-responsavels")
    public Long contarResponsavels() {
        return responsavelService.contarResponsavels();
    }

    @PostMapping("/salvar-responsavel")
    public Responsavel cadastrarResponsavel(@RequestBody Responsavel responsavel) {
        return responsavelService.cadastrarResponsavel(responsavel);
    }
    
    @DeleteMapping("/deletar-responsavel/{id}")
    public String deletarResponsavel(@PathVariable Long id) {
        if(responsavelService.deletarResponsavel(id)) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover usuário";
    }

    @GetMapping("/buscar-responsavels/{id}")
    public Responsavel buscResponsavel(@PathVariable Long id) {
        return responsavelService.buscarResponsavel(id);
    }

    @GetMapping("/listar-responsavels")
    public List<Responsavel> listaResponsavels() {
        return responsavelService.listaResponsavels();
    }

    @PutMapping("/atualizar-responsavel/{id}")
    public String atualizarResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        if(responsavelService.atualizarResponsavel(id, responsavel) != null) {
            return "Usuário atualizado com sucesso.";
        }
        return "Falha ao atualizar o usuário.";
    }
}
