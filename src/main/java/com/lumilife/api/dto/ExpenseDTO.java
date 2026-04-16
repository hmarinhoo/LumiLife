package com.lumilife.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDTO {
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private Long userId;
}
