package exalt.bankaccount.application.port.in;

import exalt.bankaccount.config.BankAccountException;
import exalt.bankaccount.domain.Account;

public interface DepositMoneyUseCase {
	
	Account depositMoney(Long accountId,float amount) throws BankAccountException;

}
