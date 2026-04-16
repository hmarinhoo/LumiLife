package com.lumilife.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumilife.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}