package com.lumilife.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lumilife.api.model.Mood;

public interface MoodRepository extends JpaRepository<Mood, Long> {

    // Buscar moods por usuário
    List<Mood> findByUserId(Long userId);

    // Buscar moods por período (EX: mês)
    List<Mood> findByUserIdAndDataBetween(Long userId, LocalDate inicio, LocalDate fim);

    // Buscar mood de um dia específico
    Mood findByUserIdAndData(Long userId, LocalDate data);
}