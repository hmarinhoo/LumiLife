package com.lumilife.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lumilife.api.dto.ExpenseDTO;
import com.lumilife.api.model.Expense;
import com.lumilife.api.model.User;
import com.lumilife.api.repository.ExpenseRepository;
import com.lumilife.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    // Criar despesa
    public Expense criar(ExpenseDTO dto) {

        User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Expense expense = new Expense();
        expense.setDescricao(dto.getDescricao());
        expense.setValor(dto.getValor());
        expense.setData(dto.getData());
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    // Listar todas
    public List<Expense> listar() {
        return expenseRepository.findAll();
    }

    // Atualizar
    public Expense atualizar(Long id, ExpenseDTO dto) {
        Expense expense = expenseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Expense não encontrada"));

        expense.setDescricao(dto.getDescricao());
        expense.setValor(dto.getValor());
        expense.setData(dto.getData());

        return expenseRepository.save(expense);
    }
}