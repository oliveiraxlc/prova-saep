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

import com.treino.senai.models.Crianca;
import com.treino.senai.services.CriancaService;



@RestController
@RequestMapping("/crianca")
public class CriancaController {

    @Autowired
    private CriancaService criancaService;

    @GetMapping("/contar-criancas")
    public Long contarCriancas() {
        return criancaService.contarCriancas();
    }

    @PostMapping("/salvar-crianca")
    public Crianca cadastrarCrianca(@RequestBody Crianca crianca) {
        return criancaService.cadastrarCrianca(crianca);
    }
    
    @DeleteMapping("/deletar-crianca/{id}")
    public String deletarCrianca(@PathVariable Long id) {
        if(criancaService.deletarCrianca(id)) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover usuário";
    }

    @GetMapping("/buscar-criancas/{id}")
    public Crianca buscCrianca(@PathVariable Long id) {
        return criancaService.buscarCrianca(id);
    }

    @GetMapping("/listar-criancas")
    public List<Crianca> listaCriancas() {
        return criancaService.listaCriancas();
    }

    @PutMapping("/atualizar-crianca/{id}")
    public String atualizarCrianca(@PathVariable Long id, @RequestBody Crianca crianca) {
        if(criancaService.atualizarCrianca(id, crianca) != null) {
            return "Usuário atualizado com sucesso.";
        }
        return "Falha ao atualizar o usuário.";
    }
}