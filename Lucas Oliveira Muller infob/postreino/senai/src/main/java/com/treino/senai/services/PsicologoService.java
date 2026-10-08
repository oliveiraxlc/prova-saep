package com.treino.senai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.treino.senai.models.Psicologo;
import com.treino.senai.repositories.PsicologoRepository;

@Service
public class PsicologoService {

    private final PsicologoRepository psicologoRepository;

    public PsicologoService(PsicologoRepository psicologoRepository) {
        this.psicologoRepository = psicologoRepository;
    }

    public List<Psicologo> listarTodos() {
        return psicologoRepository.findAll();
    }

    public Psicologo buscarPorId(Long id) {
        return psicologoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Psicólogo não encontrado com id: " + id));
    }

    public Psicologo salvar(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    public Psicologo atualizar(Long id, Psicologo psicologoAtualizado) {
        Psicologo psicologo = buscarPorId(id);
        psicologo.setUsername(psicologoAtualizado.getUsername());
        psicologo.setEmail(psicologoAtualizado.getEmail());
        psicologo.setPassword(psicologoAtualizado.getPassword());
        psicologo.setRole(psicologoAtualizado.getRole());
        return psicologoRepository.save(psicologo);
    }

    public void deletar(Long id) {
        if (!psicologoRepository.existsById(id)) {
            throw new RuntimeException("Psicólogo não encontrado com id: " + id);
        }
        psicologoRepository.deleteById(id);
    }
}

