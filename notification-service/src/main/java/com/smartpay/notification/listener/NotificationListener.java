package com.smartpay.notification.listener;

import com.smartpay.notification.dto.PaymentDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(queues = "payment.notification.queue")
    public void receiveMessage(PaymentDTO payment) {
        System.out.println("📩 Nova notificação de pagamento:");
        System.out.println("ID: " + payment.getId());
        System.out.println("Valor: " + payment.getAmount());
        System.out.println("Status: " + payment.getStatus());
    }
}