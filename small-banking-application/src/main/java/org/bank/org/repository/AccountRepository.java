package org.bank.org.repository;


import org.bank.org.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long> {
    Account findAccountById(Long id);

}