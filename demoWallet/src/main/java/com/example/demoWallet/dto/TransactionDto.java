package com.example.demoWallet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TransactionDto {
	private long transactionId;
	private long sourceId;
	@NotBlank
	@NotNull
	private long destId;
	private BigDecimal money;
	
	public TransactionDto() {};
	
	/*Deposits and subtractions: one wallet*/
	public TransactionDto(long destId,BigDecimal money) {
		this.destId = destId;
		this.money = money;
	}
	
	/*Transactions from one wallet to another*/
	public TransactionDto(long sourceId, long destId,BigDecimal money) {
		this.sourceId = sourceId;
		this.destId = destId;
		this.money = money;
	}
	
	/*Transactions from one wallet to another*/
	public TransactionDto(long transactionId, long sourceId, long destId,BigDecimal money) {
		this.sourceId = sourceId;
		this.destId = destId;
		this.money = money;
	}
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}
	public long getDestId() {
		return destId;
	}
	public void setDestId(long destId) {
		this.destId = destId;
	}

	
}
