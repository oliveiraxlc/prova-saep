package com.treino.senai.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.treino.senai.models.Psicologo;
import com.treino.senai.repositories.PsicologoRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PsicologoRepository psicologoRepository;

    public CustomUserDetailsService(PsicologoRepository psicologoRepository) {
        this.psicologoRepository = psicologoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Psicologo psicologo = psicologoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        return psicologo;
    }
}
