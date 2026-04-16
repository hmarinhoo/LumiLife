package com.lumilife.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.lumilife.api.dto.TaskDTO;
import com.lumilife.api.model.Task;
import com.lumilife.api.service.TaskService;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task criar(@RequestBody TaskDTO dto) {
        return taskService.criar(dto);
    }

    @GetMapping
    public List<Task> listar() {
        return taskService.listar();
    }

    @PutMapping("/{id}")
    public Task atualizar(@PathVariable Long id, @RequestBody TaskDTO dto) {
        return taskService.atualizar(id, dto);
    }

    @PutMapping("/{id}/concluir")
    public Task concluir(@PathVariable Long id) {
        return taskService.concluir(id);
    }
}