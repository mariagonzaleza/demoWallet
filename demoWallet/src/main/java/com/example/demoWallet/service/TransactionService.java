package com.example.demoWallet.service;
import java.util.List;

import com.example.demoWallet.dto.TransactionDto;

public interface TransactionService {
	public List<TransactionDto> getAllTransactions(); 
    public void createTransaction(TransactionDto transaction);
}
