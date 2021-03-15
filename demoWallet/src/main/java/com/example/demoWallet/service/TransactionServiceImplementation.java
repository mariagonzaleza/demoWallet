package com.example.demoWallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoWallet.dto.TransactionDto;
import com.example.demoWallet.port.TransactionPersistencePort;
@Service
public class TransactionServiceImplementation implements TransactionService {
	
	@Autowired
	private final TransactionPersistencePort transactionPersistencePort; 
	public TransactionServiceImplementation(TransactionPersistencePort transactionPersistencePort) {
		this.transactionPersistencePort = transactionPersistencePort;
	}
	
	@Override
	public List<TransactionDto> getAllTransactions() {
		return transactionPersistencePort.getAllTransactions();
	}

	@Override
	public void createTransaction(TransactionDto transaction) {
		transactionPersistencePort.createTransaction(transaction);
	}

}
