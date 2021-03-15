package com.example.demoWallet.port;
import java.util.List;

import com.example.demoWallet.dto.TransactionDto;

public interface TransactionPersistencePort {
	public List<TransactionDto> getAllTransactions(); 
    public void createTransaction(TransactionDto transaction);
}
