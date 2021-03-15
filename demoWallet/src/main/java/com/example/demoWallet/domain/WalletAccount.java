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

/*Account class*/
@Entity
@Table(name="walletaccounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletAccount {

		/*Unique id generated automatically*/
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long walletId;
		@Column(name="userid")
		private String userId;
		@Column(name="money")
		private BigDecimal money;
		
		public WalletAccount() {
			
		}
		
		/*Constructor with only user data*/
		public WalletAccount(String userId){
			this.userId = userId;
			this.money = BigDecimal.ZERO;
		}
		/*Constructor with user data and money*/
		public WalletAccount(String userId, BigDecimal money) {
			this.userId = userId;
			this.money = money;
		}

		/*Constructor with user data and money*/
		public WalletAccount(long walletId, String userId, BigDecimal money) {
			this.walletId = walletId;
			this.userId = userId;
			this.money = money;
		}
		
		
		/*Getters and Setters*/
		public long getWalletId() {
			return walletId;
		}
		
		public void setWalletId(long walletId) {
			this.walletId = walletId;
		}
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}

		public BigDecimal getMoney() {
			return money;
		}
		
		public void setMoney(BigDecimal money) {
			this.money = money;
		}
}
