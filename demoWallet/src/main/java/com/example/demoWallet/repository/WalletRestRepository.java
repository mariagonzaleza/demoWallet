package com.example.demoWallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demoWallet.domain.WalletAccount;

@RepositoryRestResource
public interface WalletRestRepository extends CrudRepository<WalletAccount, Long>{

}
