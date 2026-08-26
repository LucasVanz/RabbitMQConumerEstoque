package com.example.service;

import org.springframework.stereotype.Service;

import com.example.Entity.Estoque;
import com.example.repository.EstoqueRepositpory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstoqueService {
    
    private final EstoqueRepositpory estoqueRepositpory;

    public void salvarEstoque(String nomeProduto, int quantidade) {
        Estoque estoque = new Estoque(nomeProduto, quantidade);
        estoqueRepositpory.save(estoque);
    }
}
