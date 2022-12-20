package exalt.bankaccount.config;

import lombok.Getter;

@Getter
public class BankAccountException extends Exception{
	private Codes code;
	private String message;
	
	public BankAccountException(Codes code){
		super();
		this.code=code;
	}
	
	
	
}
