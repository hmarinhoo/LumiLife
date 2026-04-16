package com.lumilife.api.dto;

import java.time.LocalDate;

import com.lumilife.api.enums.MoodType;

import lombok.Data;

@Data
public class MoodDTO {
    private LocalDate data;
    private MoodType mood; 
    private String descricao;
    private Long userId;
}

