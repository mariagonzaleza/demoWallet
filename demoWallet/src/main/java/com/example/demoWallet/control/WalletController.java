	/*------------------------------------------------------------
					María A. González 
------------------------------------------------------------------*/

package com.example.demoWallet.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoWallet.dto.WalletAccountDto;
import com.example.demoWallet.exception.WalletAccountException;
import com.example.demoWallet.service.WalletAccountService;


@RestController
public class WalletController {
	@Autowired
	private WalletAccountService walletService; 

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /*Shows existing wallets*/
    @GetMapping(
    	    value = "/walletAccounts",
    	    produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<WalletAccountDto> getAll() throws Throwable{
    	List<WalletAccountDto> wallets = null;
        try {
        	wallets = walletService.findAllWallets();
        } catch (WalletAccountException ex) {
            logger.error("Error!", ex);
            
        }
        return wallets;

    }
    
    /*Metodo para crear wallet e ingresar moneda, espera en formato JSON ejemplo -->{"userId": "Maria", "money": "550.55"}*/
    
    @PostMapping(
    	    value = "/walletAccounts",
    	    produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Void> newWallet(@RequestBody WalletAccountDto wallet){
    	walletService.createWalletAccount(wallet);
		return new ResponseEntity<>(HttpStatus.CREATED) ;
    }
    /*Nos devuelve informacion de la cuenta correspondiente al id --> balance y usuario*/
    @GetMapping(
    	    value = "/walletAccounts/{id}",
    	    produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public WalletAccountDto getWalletById( @PathVariable("id") long id) throws Throwable{
    	WalletAccountDto wallet = null;
        try {
        	wallet = walletService.findWalletById(id);
        } catch (WalletAccountException ex) {
            logger.error("Error!", ex);
            
        }
        return wallet;

    }
    

    

    
}
