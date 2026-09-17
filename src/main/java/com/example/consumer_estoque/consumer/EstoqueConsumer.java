package com.example.consumer_estoque.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.DTO.EstoqueDTO;
import com.example.constantes.RabbitMQConstantes;
import com.example.service.EstoqueService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EstoqueConsumer {

    private final EstoqueService estoqueService;
    
    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE, containerFactory = "rabbitListenerContainerFactory")
    public void consumidor(EstoqueDTO estoqueDTO) throws InterruptedException, IllegalArgumentException {
    //    estoqueService.salvarEstoque(estoqueDTO.nomeProduto, estoqueDTO.quantidade);
    //    System.out.println("Mensagem consumida: " + estoqueDTO);
        System.out.println("Processando quantidade: " + estoqueDTO.quantidade);
        if (estoqueDTO.quantidade == 999){
           throw new RuntimeException("Falha simulada no banco");     
        }

        
        estoqueService.salvarEstoque(estoqueDTO.nomeProduto, estoqueDTO.quantidade);
    }
}
