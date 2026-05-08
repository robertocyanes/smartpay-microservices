package com.smartpay.transaction.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    @RabbitListener(queues = "payment.queue")
    public void receiveMessage(String message) {
        System.out.println("🔥 Mensagem recebida do payment-service: " + message);
    }
}