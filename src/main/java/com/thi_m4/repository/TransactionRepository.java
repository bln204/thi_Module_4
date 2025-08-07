package com.thi_m4.repository;


import com.thi_m4.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByCustomer_NameContainingAndTypeContaining(String name, String type);
}

