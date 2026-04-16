package com.lumilife.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lumilife.api.dto.TaskDTO;
import com.lumilife.api.model.Task;
import com.lumilife.api.model.User;
import com.lumilife.api.repository.TaskRepository;
import com.lumilife.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    // Criar task
    public Task criar(TaskDTO dto) {

        User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setConcluida(dto.isConcluida());
        task.setUser(user);

        return taskRepository.save(task);
    }

    // Listar todas
    public List<Task> listar() {
        return taskRepository.findAll();
    }

    // Atualizar
    public Task atualizar(Long id, TaskDTO dto) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setConcluida(dto.isConcluida());

        return taskRepository.save(task);
    }

    // Concluir
    public Task concluir(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setConcluida(true);
        return taskRepository.save(task);
    }
}