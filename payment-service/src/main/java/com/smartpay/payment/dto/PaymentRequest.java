package com.smartpay.payment.dto;

import java.math.BigDecimal;

public class PaymentRequest {

    private String description;
    private BigDecimal amount;
    private String cardNumber;
    private String status;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}