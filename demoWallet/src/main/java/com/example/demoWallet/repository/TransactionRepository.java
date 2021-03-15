package com.example.demoWallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demoWallet.domain.Transaction;
@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
}
