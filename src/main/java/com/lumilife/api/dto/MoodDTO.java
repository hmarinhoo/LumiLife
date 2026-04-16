package com.lumilife.api.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MoodDTO {
    private LocalDate data;
    private String mood;
    private String descricao;
    private Long userId;
}

