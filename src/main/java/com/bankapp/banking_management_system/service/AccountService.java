package com.bankapp.banking_management_system.service;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.bankapp.banking_management_system.entity.Account;
import com.bankapp.banking_management_system.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Not Found"));
    }

    public Account depositAmount(Long id, Double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Not Found"));

        account.setBalance(account.getBalance() + amount);

        return accountRepository.save(account);
    }

    public Account withDrawAmount(Long id, Double amount) {
        Account account = getAccountById(id);

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance!!!");
        }

        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account getAllAccountsById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Id not found!!"));
    }
}
