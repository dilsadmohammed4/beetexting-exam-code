package org.bank.org.service;

import org.bank.org.exception.BankAccountException;
import org.bank.org.model.Account;
import org.bank.org.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    //Getting Account details of particular Account
    public Account getAccountsUserById(Long id) throws BankAccountException {
        Account account = accountRepository.findAccountById(id);
        if (account != null) {
            return account;
        } else {
            throw new BankAccountException("Account not found");
        }
    }

    //Deposit money in account
    public void depositMoney(Long id, double amount) throws BankAccountException {
        Account account = accountRepository.findAccountById(id);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        } else {
            throw new BankAccountException("Account not found");
        }
    }

    //Withdraw money from account
    public void withdrawMoney(Long id, double amount) throws BankAccountException {
        Account account = accountRepository.findAccountById(id);
        if (account != null) {
            double balance = account.getBalance();
            if (balance >= amount & balance >= 0) {
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
            } else {
                throw new BankAccountException("Insufficient funds");
            }
        } else {
            throw new BankAccountException("Account not found");
        }

    }

}