package com.bankapp.banking_management_system.controller;

import com.bankapp.banking_management_system.dto.AccountDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bankapp.banking_management_system.entity.Account;
import com.bankapp.banking_management_system.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PutMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestParam Double amount) {
        return accountService.depositAmount(id, amount);
    }

    @PutMapping("/withdraw/{id}")
    public Account withDraw(@PathVariable Long id, @RequestParam Double amount) {
        return accountService.withDrawAmount(id, amount);
    }

    @PostMapping("/create")
    public Account createAccount(@Valid @RequestBody AccountDto accountDto) {
        Account account = new Account();

        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(account.getAccountType());
        account.setBalance(accountDto.getBalance());

        return accountService.saveAccount(account);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccount() {

        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/getAllAccountsById/{id}")
    public ResponseEntity<Account> getAllAccountById(@PathVariable Long id) {

        return ResponseEntity.ok(accountService.getAllAccountsById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @Valid @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.updateAccount(id, accountDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }

}
