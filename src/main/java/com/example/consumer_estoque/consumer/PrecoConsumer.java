package com.example.consumer_estoque.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.DTO.PrecoDTO;
import com.example.service.PrecoService;
import com.microsservicos.avro.Preco;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Component 
@RequiredArgsConstructor 
public class PrecoConsumer {
    
    private final PrecoService precoService;

    @KafkaListener(topics = "preco", groupId = "demo")
    public void consumidor(Preco precoAvro) {
        //ObjectMapper objectMapper = new ObjectMapper();
        //PrecoDTO precoDTO = objectMapper.readValue(json, PrecoDTO.class);
        //System.out.println("Processando preço: " + precoDTO.preco);
       // precoService.salvarPreco(precoDTO.nomeProduto, precoDTO.preco);
       
        System.out.println("Processando preço: " + precoAvro.getNomeProduto());
        precoService.salvarPreco(precoAvro.getNomeProduto().toString(), precoAvro.getPreco());
    }

}
