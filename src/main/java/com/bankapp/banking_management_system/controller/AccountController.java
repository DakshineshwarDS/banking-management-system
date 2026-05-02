package com.bankapp.banking_management_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
