package com.lumilife.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import com.lumilife.api.dto.MoodDTO;
import com.lumilife.api.model.Mood;
import com.lumilife.api.service.MoodService;

@RestController
@RequestMapping("/moods")
@RequiredArgsConstructor
public class MoodController {

    private final MoodService moodService;

    @PostMapping
    public Mood criar(@RequestBody MoodDTO dto) {
        return moodService.criar(dto);
    }

    @GetMapping
    public List<Mood> listar() {
        return moodService.listar();
    }

    @PutMapping("/{id}")
    public Mood atualizar(@PathVariable Long id, @RequestBody MoodDTO dto) {
        return moodService.atualizar(id, dto);
    }

    // Ideia de calendário - histórico mensal de moods
    @GetMapping("/periodo") 
    public List<Mood> buscarPorPeriodo(
        @RequestParam Long userId,
        @RequestParam LocalDate inicio,
        @RequestParam LocalDate fim) {

        return moodService.buscarPorPeriodo(userId, inicio, fim);
}

    // Mood de um dia específico
    @GetMapping("/dia")
    public Mood buscarPorData(
            @RequestParam Long userId,
            @RequestParam LocalDate data) {

        return moodService.buscarPorData(userId, data);
    }
}