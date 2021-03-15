package com.example.demoWallet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class WalletAccountDto {
	private long walletId;
	@NotBlank
	@NotNull
	private String userId;
	private BigDecimal money;
	
	public WalletAccountDto(){
		
	}
	
	/*Constructor with only user data*/
	public WalletAccountDto(String userId){
		this.userId = userId;
		this.money = BigDecimal.ZERO;
	}
	/*Constructor with user data and money*/
	public WalletAccountDto(String userId, BigDecimal money) {
		this.userId = userId;
		this.money = money;
	}
	
	public WalletAccountDto(long walletId, String userId, BigDecimal money) {
		this.walletId = walletId;
		this.userId = userId;
		this.money = money;
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

	public long getWalletId() {
		return walletId;
	}

	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}

	
}
