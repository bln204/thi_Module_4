package com.thi_m4.service;

import com.thi_m4.model.Transaction;
import com.thi_m4.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void save(Transaction transaction) {
        if (transaction.getId() == null || transaction.getId().isEmpty()) {
            int count = (int) transactionRepository.count();
            String newId = String.format("MGD-%03d", count + 1);
            transaction.setId(newId);
        }
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteById(String id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> search(String customerName, String type) {
        return transactionRepository.findByCustomer_NameContainingAndTypeContaining(customerName, type);
    }
}
