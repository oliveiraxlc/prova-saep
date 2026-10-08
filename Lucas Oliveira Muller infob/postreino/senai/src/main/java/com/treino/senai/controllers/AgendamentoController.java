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

import com.treino.senai.models.Agendamento;
import com.treino.senai.services.AgendamentoService;



@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/contar-agendamentos")
    public Long contarAgendamentos() {
        return agendamentoService.contarAgendamentos();
    }

    @PostMapping("/salvar-agendamento")
    public Agendamento cadastrarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.cadastrarAgendamento(agendamento);
    }
    
    @DeleteMapping("/deletar-agendamento/{id}")
    public String deletarAgendamento(@PathVariable Long id) {
        if(agendamentoService.deletarAgendamento(id)) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover usuário";
    }

    @GetMapping("/buscar-agendamentos/{id}")
    public Agendamento buscAgendamento(@PathVariable Long id) {
        return agendamentoService.buscarAgendamento(id);
    }

    @GetMapping("/listar-agendamentos")
    public List<Agendamento> listaAgendamentos() {
        return agendamentoService.listaAgendamentos();
    }

}