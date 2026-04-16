package com.lumilife.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lumilife.api.dto.MoodDTO;
import com.lumilife.api.model.Mood;
import com.lumilife.api.model.User;
import com.lumilife.api.repository.MoodRepository;
import com.lumilife.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MoodService {

    private final MoodRepository moodRepository;
    private final UserRepository userRepository;

    // Criar mood
    public Mood criar(MoodDTO dto) {

        User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Mood mood = new Mood();
        mood.setData(dto.getData());
        mood.setMood(dto.getMood());
        mood.setDescricao(dto.getDescricao());
        mood.setUser(user);

        return moodRepository.save(mood);
    }

    // Listar todos
    public List<Mood> listar() {
        return moodRepository.findAll();
    }

    // Buscar por usuário
    public List<Mood> buscarPorUsuario(Long userId) {
        return moodRepository.findByUserId(userId);
    }

    // Buscar por período (calendário)
    public List<Mood> buscarPorPeriodo(Long userId, LocalDate inicio, LocalDate fim) {
        return moodRepository.findByUserIdAndDataBetween(userId, inicio, fim);
    }

    // Buscar por data
    public Mood buscarPorData(Long userId, LocalDate data) {
        return moodRepository.findByUserIdAndData(userId, data);
    }

    // Atualizar
    public Mood atualizar(Long id, MoodDTO dto) {
        Mood mood = moodRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mood não encontrado"));

        mood.setData(dto.getData());
        mood.setMood(dto.getMood());
        mood.setDescricao(dto.getDescricao());

        return moodRepository.save(mood);
    }
}