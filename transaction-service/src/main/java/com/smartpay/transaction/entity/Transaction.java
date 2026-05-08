package com.smartpay.transaction.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double amount;
    private String status;

    public Transaction() {}

    public Transaction(String description, Double amount, String status) {
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() { return id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}