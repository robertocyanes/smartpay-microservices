package com.smartpay.payment.messaging;

import com.smartpay.payment.entity.Payment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentPublisher {

    private final RabbitTemplate rabbitTemplate;

    public PaymentPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(Payment payment) {
        rabbitTemplate.convertAndSend(
                "payment.exchange",
                "payment.routing.key",
                payment
        );
    }
}