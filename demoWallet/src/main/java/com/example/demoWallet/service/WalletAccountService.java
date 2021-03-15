package com.example.demoWallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demoWallet.dto.WalletAccountDto;


public interface WalletAccountService {
	
	/*Declaration of WalletAccount Methods*/
	public void createWalletAccount(WalletAccountDto wallet);
	
	public WalletAccountDto findWalletById(long id) throws  Throwable;
	
	public List<WalletAccountDto> findAllWallets() throws Throwable;
	
	public void addMoney(BigDecimal money, WalletAccountDto wallet);
	
	public void subtractMoney(BigDecimal money, WalletAccountDto wallet);
	
}
