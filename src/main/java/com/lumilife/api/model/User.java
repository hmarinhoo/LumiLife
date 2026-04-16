package com.lumilife.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") 
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;
    
    private String senha;
}