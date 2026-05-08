package com.smartpay.transaction.messaging;

public class PaymentMessage {

    private String description;
    private Double amount;

    public PaymentMessage() {}

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }
}