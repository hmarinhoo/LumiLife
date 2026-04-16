package com.lumilife.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lumilife.api.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}