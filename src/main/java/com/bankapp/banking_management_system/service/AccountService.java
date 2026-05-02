package com.bankapp.banking_management_system.service;

import org.springframework.stereotype.Service;

import com.bankapp.banking_management_system.entity.Account;
import com.bankapp.banking_management_system.repository.AccountRepository;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
