package com.bankapp.banking_management_system.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.banking_management_system.entity.Account;
import com.bankapp.banking_management_system.service.AccountService;

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

}
