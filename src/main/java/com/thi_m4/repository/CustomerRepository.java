package com.thi_m4.repository;

import com.thi_m4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, String> {
}
