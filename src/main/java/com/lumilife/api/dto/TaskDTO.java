package com.lumilife.api.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private String titulo;
    private String descricao;
    private boolean concluida;
    private Long userId;
}