package com.smartpay.payment.dto;

import com.smartpay.payment.entity.PaymentStatus;
import java.math.BigDecimal;

public class PaymentResponse {

    private Long id;
    private String description;
    private BigDecimal amount;
    private String cardNumber;
    private PaymentStatus status;

    public PaymentResponse(Long id, String description, BigDecimal amount, String cardNumber, PaymentStatus status) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getDescription() { return description; }
    public BigDecimal getAmount() { return amount; }
    public String getCardNumber() { return cardNumber; }
    public PaymentStatus getStatus() { return status; }
}