package com.example.demoWallet.exception;

public class WalletAccountException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5391311577880068123L;

	public WalletAccountException (Long id) {
        super("Wallet with id %s not found!".formatted(id));
    }
	

}
