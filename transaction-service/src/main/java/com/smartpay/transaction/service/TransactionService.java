package com.smartpay.transaction.service;

import com.smartpay.transaction.entity.Transaction;
import com.smartpay.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }
}