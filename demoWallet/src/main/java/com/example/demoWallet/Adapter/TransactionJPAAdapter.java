package com.example.demoWallet.Adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoWallet.domain.Transaction;
import com.example.demoWallet.dto.TransactionDto;
import com.example.demoWallet.port.TransactionPersistencePort;
import com.example.demoWallet.repository.TransactionRepository;



@Service
public class TransactionJPAAdapter implements TransactionPersistencePort {
	@Autowired
	private TransactionRepository transactionRepository; 
	
	@Override
	public void createTransaction(TransactionDto transaction) {
		transactionRepository.save(getTransactionEntity(transaction));
	}
	

	@Override
	public List<TransactionDto> getAllTransactions() {
		
		return getTransactionDto(transactionRepository.findAll());
	}
	
	private List<TransactionDto> getTransactionDto(Iterable<Transaction> findAll) {
		// TODO Auto-generated method stub
		List<TransactionDto> list= new ArrayList<TransactionDto>();
		for(Transaction t : findAll){
			list.add(new TransactionDto(t.getTransactionId(), t.getSourceId(), t.getDestId(), t.getMoney()));
		}
		return list;
	}

	private Transaction getTransactionEntity(TransactionDto transactionDto){
		return new Transaction(transactionDto.getSourceId(), transactionDto.getDestId(), transactionDto.getMoney());
	}



}
