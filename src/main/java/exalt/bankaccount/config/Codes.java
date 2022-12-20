package exalt.bankaccount.config;

import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public enum Codes {
	AC_01("Account not found",HttpStatus.NOT_FOUND),
	AC_02("The amount is superior to the balance of the account",HttpStatus.BAD_REQUEST),
	AC_03("Amount is zero",HttpStatus.BAD_REQUEST);
	
	private String message;
	private HttpStatus httpStatus;
	
	
	Codes(String message,HttpStatus httpStatus){
		this.message=message;
		this.httpStatus=httpStatus;
	}
}
