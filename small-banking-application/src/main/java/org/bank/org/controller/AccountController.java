package org.bank.org.controller;


import org.bank.org.exception.BankAccountException;
import org.bank.org.model.Account;
import org.bank.org.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccountDetails(@PathVariable Long id) throws BankAccountException {
        return accountService.getAccountsUserById(id);
    }

    @PostMapping("/{id}/deposit")
    public void depositMoneyInAccount(@PathVariable Long id, @RequestParam double amount) throws BankAccountException {
        accountService.depositMoney(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public void withdrawMoneyFromAccount(@PathVariable Long id, @RequestParam double amount) throws BankAccountException {
        accountService.withdrawMoney(id, amount);
    }
}