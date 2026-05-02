package com.bankapp.banking_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.banking_management_system.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
