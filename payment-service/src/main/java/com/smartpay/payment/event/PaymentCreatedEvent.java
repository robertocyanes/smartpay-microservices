package com.smartpay.payment.event;

import java.math.BigDecimal;

public class PaymentCreatedEvent {

    private Long id;
    private String description;
    private BigDecimal amount;
    private String status;

    public PaymentCreatedEvent(Long id, String description, BigDecimal amount, String status) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getDescription() { return description; }
    public BigDecimal getAmount() { return amount; }
    public String getStatus() { return status; }
}