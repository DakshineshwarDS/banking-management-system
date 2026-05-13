package com.bankapp.banking_management_system.repository;

import com.bankapp.banking_management_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
