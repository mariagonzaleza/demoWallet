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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoWallet.dto.TransactionDto;
import com.example.demoWallet.exception.WalletAccountException;
import com.example.demoWallet.service.TransactionService;
import com.example.demoWallet.service.WalletAccountService;

@RestController
public class TransactionController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private WalletAccountService walletService; 
	
	/*Método para mostrar todas las transacciones					
  						*/
    @GetMapping(
    	    value = "/transactions",
    	    produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<TransactionDto> getTransactionByWalletId() throws Throwable{
    	List<TransactionDto> transactions = null;
        try {
        	transactions = transactionService.getAllTransactions();
        } catch (WalletAccountException ex) {
            logger.error("Error!", ex);
            
        }
        return transactions;

    }
	
	
	/*Método para crear Nueva Transacción espera los datos del objeto TransactionDto en Formato
	 * JSON --->EJEMPLO {  "sourceId": 2,
  						"destId": 1,
  						"money": "12.50"}
  -------------------------------------------------------------
  DESPUES DE HACER LA TRANSACCION PODEMOS COMPROBAR LAS WALLETS CON SUS RESPECTIVOS BALANCES:
  localhost:8080/walletAccounts --> Veremos que la transaccion de source a dest a actualizado sus respectivos balances 						
  						*/
	@PostMapping(
	    	    value = "/transactions",
	    	    produces = MediaType.APPLICATION_JSON_VALUE
	    )
	    @ResponseBody
	    public ResponseEntity<Void> newTransaction(@RequestBody TransactionDto transaction){
		//La transacción sólo se realiza si los ids de las wallets existen !!
		try {
			walletService.findWalletById(transaction.getSourceId());
			walletService.findWalletById(transaction.getDestId());
			//Actualizo la tabla transacción
			transactionService.createTransaction(transaction);
			//Actualizo balance en wallet receptora
			walletService.addMoney(transaction.getMoney(), walletService.findWalletById(transaction.getDestId()));
			//Actualizo balance en wallet emisora
			walletService.subtractMoney(transaction.getMoney(), walletService.findWalletById(transaction.getSourceId()));
		} catch (Throwable e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
    	
		return new ResponseEntity<>(HttpStatus.CREATED) ;
    }
	    
}
