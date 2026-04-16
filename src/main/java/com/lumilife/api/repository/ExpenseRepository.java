package com.lumilife.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lumilife.api.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}