package com.example.demoWallet.Adapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoWallet.domain.WalletAccount;
import com.example.demoWallet.dto.WalletAccountDto;
import com.example.demoWallet.exception.WalletAccountException;
import com.example.demoWallet.port.WalletAccountPersistencePort;
import com.example.demoWallet.repository.WalletRestRepository;

import lombok.SneakyThrows;
@Service
public class WalletAccountJPAAdapter implements WalletAccountPersistencePort {
	@Autowired
	private WalletRestRepository walletRestRepository;  
	
	/*Creates a new wallet*/
	@Override
	public void createWalletAccount(WalletAccountDto wallet) {
		WalletAccount walletEntity = getWalletEntity(wallet);
		walletRestRepository.save(walletEntity);
	};
	
	/*Finds wallet by walletId*/
	@SneakyThrows
	@Override
	public WalletAccountDto findWalletById(long id) throws Throwable{
	 return	getWalletDto(walletRestRepository.findById(id)
                .orElseThrow((Supplier<Throwable>) () -> new WalletAccountException(id)));
	};
	
	/*Finds existing wallets*/
	@Override
	public List<WalletAccountDto> findAllWallets() throws Throwable{
		List<WalletAccount> list= (List<WalletAccount>) walletRestRepository.findAll();
		List<WalletAccountDto> result = (List<WalletAccountDto>) new ArrayList(); 
		for(WalletAccount w: list) {
			result.add(getWalletDto(w));
		}
		return result; 
	};
	@Override
	public void addMoney(BigDecimal money, WalletAccountDto wallet) {
		//add amount of deposit 
		wallet.setMoney(wallet.getMoney().add(money));
		//Update register
		walletRestRepository.save(getWalletEntity(wallet));
	};
	@Override
	public void subtractMoney(BigDecimal money, WalletAccountDto wallet) {
		//add amount of deposit 
		wallet.setMoney(wallet.getMoney().subtract(money));
		//Update register
		walletRestRepository.save(getWalletEntity(wallet));
	};

    private WalletAccount getWalletEntity(WalletAccountDto wallet) {
        return new WalletAccount(wallet.getWalletId(), wallet.getUserId(), wallet.getMoney()) ;

    }
    
    private WalletAccountDto getWalletDto(WalletAccount wallet) {
        return new WalletAccountDto(wallet.getWalletId(),wallet.getUserId(), wallet.getMoney());

    }
}
