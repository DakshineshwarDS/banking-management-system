package com.bankapp.banking_management_system.service;

import javax.management.RuntimeErrorException;

import com.bankapp.banking_management_system.dto.AccountDto;
import com.bankapp.banking_management_system.entity.Transaction;
import com.bankapp.banking_management_system.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import com.bankapp.banking_management_system.entity.Account;
import com.bankapp.banking_management_system.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Not Found"));
    }

    public Account depositAmount(Long id, Double amount) {
        Account account = getAccountById(id);

        account.setBalance(account.getBalance() + amount);

        Transaction transaction = new Transaction();

        transaction.setTransactionType("DEPOSIT");
        transaction.setAmount(amount);
        transaction.setAccount(account);

        transactionRepository.save(transaction);

        return accountRepository.save(account);
    }

    public Account withDrawAmount(Long id, Double amount) {
        Account account = getAccountById(id);

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance!!!");
        }

        account.setBalance(account.getBalance() - amount);

        Transaction transaction = new Transaction();

        transaction.setTransactionType("WITHDRAW");
        transaction.setAmount(amount);
        transaction.setAccount(account);

        transactionRepository.save(transaction);
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account getAllAccountsById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Id not found!!"));
    }

    public  Account updateAccount(Long id, AccountDto accountDto) {
        Account existingAccount = getAccountById(id);

        existingAccount.setAccountHolderName(accountDto.getAccountHolderName());
        existingAccount.setAccountNumber(accountDto.getAccountNumber());
        existingAccount.setAccountType(accountDto.getAccountType());
        existingAccount.setBalance(accountDto.getBalance());

        return accountRepository.save(existingAccount);
    }

    public String deleteAccount(Long id) {
        Account deleteAccount = getAccountById(id);

        accountRepository.delete(deleteAccount);

        return "Account deleted successfully!!";
    }
}
