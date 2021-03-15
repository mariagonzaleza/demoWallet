package com.example.demoWallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoWallet.dto.WalletAccountDto;
import com.example.demoWallet.port.WalletAccountPersistencePort;
@Service
public class WalletServiceImplementation implements WalletAccountService{
	@Autowired
    private final WalletAccountPersistencePort walletPersistencePort;

    public WalletServiceImplementation(WalletAccountPersistencePort walletPersistencePort) {
        this.walletPersistencePort = walletPersistencePort;
    }
    
    @Override
	public void createWalletAccount(WalletAccountDto wallet) {
		walletPersistencePort.createWalletAccount(wallet);
	}
    
	@Override
	public WalletAccountDto findWalletById(long id) throws Throwable {	
		return this.walletPersistencePort.findWalletById(id);
	}
	
	@Override
	public List<WalletAccountDto> findAllWallets() throws Throwable {
		return this.walletPersistencePort.findAllWallets();
	}
	@Override
	public void addMoney(BigDecimal money, WalletAccountDto wallet) {
		this.walletPersistencePort.addMoney(money, wallet);
	};
	
	@Override
	public void subtractMoney(BigDecimal money, WalletAccountDto wallet) {
		this.walletPersistencePort.subtractMoney(money, wallet);
	};
	

}
