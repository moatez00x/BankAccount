package exalt.bankaccount.application.port.in;

import exalt.bankaccount.domain.Account;

public interface DepositMoneyUseCase {
	
	Account depositMoney(String accountId,float amount);

}
