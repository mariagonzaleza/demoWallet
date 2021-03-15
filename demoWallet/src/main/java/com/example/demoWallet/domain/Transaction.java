package com.example.demoWallet.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId; 
	@Column(name="sourceId")
	private long sourceId;
	@Column(name="destId")
	private long destId;
	@Column (name="money")
	private BigDecimal money;
	
	public Transaction() {
	}
	
	/*Deposits and subtractions: one wallet*/
	public Transaction(long destId,BigDecimal money) {
		this.destId = destId;
		this.money = money;
	}
	
	/*Transactions from one wallet to another*/
	public Transaction(long sourceId, long destId,BigDecimal money) {
		this.sourceId = sourceId;
		this.destId = destId;
		this.money = money;
	}
	

	public long getDestId() {
		return destId;
	}

	public void setDestId(long destId) {
		this.destId = destId;
	}

	public long getSourceId() {
		return sourceId;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}


	
}
