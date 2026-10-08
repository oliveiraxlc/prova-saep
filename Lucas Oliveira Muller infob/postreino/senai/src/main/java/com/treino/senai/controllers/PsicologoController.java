package com.treino.senai.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.senai.models.Psicologo;
import com.treino.senai.services.PsicologoService;

@RestController
@RequestMapping("/psicologo")
public class PsicologoController {

    private final PsicologoService psicologoService;

    public PsicologoController(PsicologoService psicologoService) {
        this.psicologoService = psicologoService;
    }

    @GetMapping("/contar-psicologos")
    public long contarPsicologos() {
        return psicologoService.listarTodos().size();
    }

    @PostMapping("/salvar-psicologo")
    public Psicologo cadastrarPsicologo(@RequestBody Psicologo psicologo) {
        return psicologoService.salvar(psicologo);
    }

    @DeleteMapping("/deletar-psicologo/{id}")
    public String deletarPsicologo(@PathVariable Long id) {
        psicologoService.deletar(id);
        return "Usuário removido com sucesso";
    }

    @GetMapping("/buscar-psicologos/{id}")
    public Psicologo buscPsicologo(@PathVariable Long id) {
        return psicologoService.buscarPorId(id);
    }

    @GetMapping("/listar-psicologos")
    public List<Psicologo> listaPsicologos() {
        return psicologoService.listarTodos();
    }

    @PutMapping("/atualizar-psicologo/{id}")
    public String atualizarPsicologo(@PathVariable Long id, @RequestBody Psicologo psicologo) {
        psicologoService.atualizar(id, psicologo);
        return "Usuário atualizado com sucesso.";
    }
}
