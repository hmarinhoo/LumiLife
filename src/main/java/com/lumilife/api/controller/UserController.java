package com.lumilife.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.lumilife.api.dto.UserDTO;
import com.lumilife.api.model.User;
import com.lumilife.api.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User criar(@RequestBody UserDTO dto) {
        return userService.criar(dto);
    }

    @GetMapping
    public List<User> listar() {
        return userService.listar();
    }

    @GetMapping("/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public User atualizar(@PathVariable Long id, @RequestBody UserDTO dto) {
        return userService.atualizar(id, dto);
    }
}