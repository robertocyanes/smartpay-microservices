package com.smartpay.payment.service;

import com.smartpay.payment.dto.PaymentRequest;
import com.smartpay.payment.entity.Payment;
import com.smartpay.payment.entity.PaymentStatus;
import com.smartpay.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment createPayment(PaymentRequest request) {

        Payment payment = new Payment();
        payment.setDescription(request.getDescription());
        payment.setAmount(request.getAmount());
        payment.setCardNumber(request.getCardNumber());
        payment.setStatus(parseStatus(request.getStatus()));

        return repository.save(payment);
    }

    public List<Payment> findAll() {
        return repository.findAll();
    }

    private PaymentStatus parseStatus(String status) {
        try {
            return status == null
                    ? PaymentStatus.PENDING
                    : PaymentStatus.valueOf(status.toUpperCase());
        } catch (Exception e) {
            return PaymentStatus.PENDING;
        }
    }
}