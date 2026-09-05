package com.example.service;

import org.springframework.stereotype.Service;

import com.example.Entity.Preco;
import com.example.repository.PrecoRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class PrecoService {
    
    private final PrecoRepository precoRepository;

    public void salvarPreco(String nomePrduto, Double valor){
        Preco preco = new Preco(nomePrduto, valor);
        precoRepository.save(preco);
    }

}
