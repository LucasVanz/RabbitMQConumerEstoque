package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Estoque;

public interface EstoqueRepositpory extends JpaRepository<Estoque, Long>{
    
}
