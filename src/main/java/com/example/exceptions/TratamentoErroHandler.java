package com.example.exceptions;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.listener.ListenerExecutionFailedException;
import org.springframework.util.ErrorHandler;

public class TratamentoErroHandler implements ErrorHandler{
    
    @Override
    public void handleError(Throwable t) {
        String nomeDaFila = ((ListenerExecutionFailedException) t).getFailedMessage().getMessageProperties().getConsumerQueue();
        String mensagem = new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody());
        System.out.println("Erro ao processar a mensagem da fila: " + nomeDaFila);
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Erro: " + t.getCause().getMessage());

        throw new AmqpRejectAndDontRequeueException("Não deve retornar a fila");
    }
    
}
