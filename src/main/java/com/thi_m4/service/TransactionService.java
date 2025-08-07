package com.thi_m4.service;

import com.thi_m4.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> findAll();
    Optional<Transaction> findById(String id);
    void save(Transaction transaction);
    void deleteById(String id);
    List<Transaction> search(String customerName, String type);
    String generateNewId();
}
