package com.example.demoWallet.port;

import java.math.BigDecimal;
import java.util.List;

import com.example.demoWallet.dto.WalletAccountDto;

public interface WalletAccountPersistencePort {
	public void createWalletAccount(WalletAccountDto wallet);
	
	public WalletAccountDto findWalletById(long id) throws Throwable;
	
	public List<WalletAccountDto> findAllWallets() throws Throwable;
	
	public void addMoney(BigDecimal money, WalletAccountDto wallet);
	
	public void subtractMoney(BigDecimal money, WalletAccountDto wallet);
}
