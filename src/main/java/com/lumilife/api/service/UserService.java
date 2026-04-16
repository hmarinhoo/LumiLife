package com.lumilife.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lumilife.api.dto.UserDTO;
import com.lumilife.api.model.User;
import com.lumilife.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Criar usuário
    public User criar(UserDTO dto) {
        User user = new User();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());

        return userRepository.save(user);
    }

    // Listar usuários
    public List<User> listar() {
        return userRepository.findAll();
    }

    // Buscar por ID
    public User buscarPorId(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // Atualizar
    public User atualizar(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());

        return userRepository.save(user);
    }
}