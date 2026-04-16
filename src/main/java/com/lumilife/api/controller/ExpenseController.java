package com.lumilife.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.lumilife.api.dto.ExpenseDTO;
import com.lumilife.api.model.Expense;
import com.lumilife.api.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public Expense criar(@RequestBody ExpenseDTO dto) {
        return expenseService.criar(dto);
    }

    @GetMapping
    public List<Expense> listar() {
        return expenseService.listar();
    }

    @PutMapping("/{id}")
    public Expense atualizar(@PathVariable Long id, @RequestBody ExpenseDTO dto) {
        return expenseService.atualizar(id, dto);
    }
}