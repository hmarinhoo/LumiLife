package com.lumilife.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

import com.lumilife.api.enums.MoodType;

@Entity
@Data
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private String mood;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private MoodType Mood;
}